package com.sahiva.pam.tugas1

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform