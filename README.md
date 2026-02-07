# Agenda Widget (Android)

App Android em Kotlin com um **widget** que mostra os eventos do dia a partir do **Android Calendar Provider** (os calendários já sincronizados no aparelho, incluindo Google).

## MVP
- Widget mostra até 8 eventos de hoje no formato `HH:mm — Título`.
- Sem eventos: `Nenhum evento hoje.`
- Sem permissão: `Sem permissão de calendário. Abra o app e conceda acesso.`
- Tocar no widget abre o app (tela simples que pede permissão).

## Requisitos
- Android Studio (JDK 17)
- Min SDK 26 (Android 8.0)

## Rodar
1. Abra este projeto no Android Studio.
2. Rode no emulador/aparelho.
3. Conceda a permissão de calendário quando solicitado.
4. Adicione o widget na Home.

## CI
GitHub Actions roda build/test/lint em PRs e pushes.
