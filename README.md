# Agenda Widget (Android)

## Objetivo
Aplicativo Android em Kotlin com um widget que mostra os eventos de hoje.
Fonte dos dados: Android Calendar Provider (calendários já sincronizados no aparelho, incluindo Google).

## Funcionalidades (MVP)
- Widget mostra lista de eventos de hoje (hora + título).
- Atualização periódica a cada 30 minutos.
- Ao tocar no widget, abre o app.

## Stack
- Kotlin
- AppWidget (RemoteViews)
- Leitura via Calendar Provider
- WorkManager para atualização

## Permissões
- READ_CALENDAR (Android 13+ pode exigir runtime permission no app)

## Rodar local
- Abra no Android Studio
- Run no emulador ou aparelho

## CI
GitHub Actions roda:
- assembleDebug
- test
- lint
