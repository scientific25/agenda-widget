package com.seuusuario.agendawidget

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat

class MainActivity : ComponentActivity() {

    private val requestCalendarPermission =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { granted ->
            if (granted) {
                Toast.makeText(this, "Permissão concedida! Atualize o widget.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Sem permissão, não dá para ler eventos.", Toast.LENGTH_SHORT).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val hasPermission = ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.READ_CALENDAR
        ) == PackageManager.PERMISSION_GRANTED

        if (!hasPermission) {
            requestCalendarPermission.launch(Manifest.permission.READ_CALENDAR)
        } else {
            Toast.makeText(this, "Ok! Já tenho permissão. Atualize o widget.", Toast.LENGTH_SHORT).show()
        }
    }
}
