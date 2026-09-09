package com.sahiva.pam.tugas1

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "PAM_Tugas1",
    ) {
        App()
    }
}