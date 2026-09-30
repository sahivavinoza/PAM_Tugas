package com.example.pam_tugas3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.pam_tugas3.ui.theme.PAM_Tugas3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PAM_Tugas3Theme {
                // Pastikan Anda sudah membuat file ProfileScreen.kt nanti
                ProfileScreen()
            }
        }
    }
}