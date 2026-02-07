package com.seuusuario.agendawidget.data

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.provider.CalendarContract
import androidx.core.content.ContextCompat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import java.util.TimeZone

object CalendarTodayReader {

    fun readTodayEventsText(context: Context): String {
        val hasPermission = ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.READ_CALENDAR
        ) == PackageManager.PERMISSION_GRANTED

        if (!hasPermission) {
            return "Sem permissão de calendário.\nAbra o app e conceda acesso."
        }

        val now = Calendar.getInstance()

        val start = (now.clone() as Calendar).apply {
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }.timeInMillis

        val end = (now.clone() as Calendar).apply {
            set(Calendar.HOUR_OF_DAY, 23)
            set(Calendar.MINUTE, 59)
            set(Calendar.SECOND, 59)
            set(Calendar.MILLISECOND, 999)
        }.timeInMillis

        val projection = arrayOf(
            CalendarContract.Instances.BEGIN,
            CalendarContract.Instances.TITLE
        )

        val selection = "((${CalendarContract.Instances.BEGIN} >= ?) AND (${CalendarContract.Instances.BEGIN} <= ?))"
        val selectionArgs = arrayOf(start.toString(), end.toString())
        val sortOrder = "${CalendarContract.Instances.BEGIN} ASC"

        val uri = CalendarContract.Instances.CONTENT_URI.buildUpon()
            .appendPath(start.toString())
            .appendPath(end.toString())
            .build()

        val sdf = SimpleDateFormat("HH:mm", Locale.getDefault()).apply {
            timeZone = TimeZone.getDefault()
        }

        val lines = mutableListOf<String>()

        context.contentResolver.query(uri, projection, selection, selectionArgs, sortOrder)
            ?.use { cursor ->
                val beginIdx = cursor.getColumnIndex(CalendarContract.Instances.BEGIN)
                val titleIdx = cursor.getColumnIndex(CalendarContract.Instances.TITLE)

                while (cursor.moveToNext()) {
                    val begin = cursor.getLong(beginIdx)
                    val title = cursor.getString(titleIdx) ?: "(Sem título)"
                    val time = sdf.format(Date(begin))
                    lines.add("$time — $title")
                    if (lines.size >= 8) break
                }
            }

        return if (lines.isEmpty()) "Nenhum evento hoje." else lines.joinToString("\n")
    }
}
