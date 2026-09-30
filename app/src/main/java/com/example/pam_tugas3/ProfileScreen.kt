package com.example.pam_tugas3

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// 1. Reusable Composable: ProfileHeader (Sesuai instruksi: foto circular/lingkaran)
@Composable
fun ProfileHeader(
    name: String,
    role: String,
    bio: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(110.dp)
                .clip(CircleShape) // Bentuk lingkaran (Circular) sesuai instruksi tugas
                .background(Color(0xFFE5DFD3))
                .border(3.dp, Color(0xFF5A4D41), CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Foto Profil",
                modifier = Modifier.size(65.dp),
                tint = Color(0xFF332F2C)
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = name,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF332F2C)
        )

        Text(
            text = role,
            fontSize = 14.sp,
            color = Color(0xFF5A4D41),
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = bio,
            fontSize = 13.sp,
            textAlign = TextAlign.Center,
            color = Color(0xFF7A736D),
            modifier = Modifier.padding(horizontal = 24.dp)
        )
    }
}

// 2. Reusable Composable: InfoItem (List informasi Email, Phone, Location)
@Composable
fun InfoItem(
    icon: ImageVector,
    label: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color(0xFFF0ECE1)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = Color(0xFF5A4D41),
                modifier = Modifier.size(22.dp)
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(
                text = label,
                fontSize = 12.sp,
                color = Color(0xFF7A736D)
            )
            Text(
                text = value,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF332F2C)
            )
        }
    }
}

// 3. Reusable Composable: ProfileCard
@Composable
fun ProfileCard(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            content = content
        )
    }
}

// Halaman Utama ProfileScreen
@Composable
fun ProfileScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFF4F1EA) // Tema warna hangat estetis ala Hirono
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            ProfileHeader(
                name = "Sahiva Syamdo Vinoza",
                role = "Teknik Informatika - ITERA",
                bio = "Mahasiswa Informatika yang berfokus pada pengembangan aplikasi mobile dan rekayasa perangkat lunak."
            )

            Spacer(modifier = Modifier.height(24.dp))

            ProfileCard {
                Text(
                    text = "Informasi Kontak & Domisili",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF5A4D41),
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(Color(0xFFE5DFD3))
                )

                Spacer(modifier = Modifier.height(8.dp))

                InfoItem(
                    icon = Icons.Default.Email,
                    label = "Email Kampus",
                    value = "sahiva.123140194@student.itera.ac.id"
                )

                InfoItem(
                    icon = Icons.Default.Phone,
                    label = "Nomor Telepon",
                    value = "+62 812-3456-7890"
                )

                InfoItem(
                    icon = Icons.Default.LocationOn,
                    label = "Lokasi",
                    value = "Bandar Lampung, Indonesia"
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5A4D41))
            ) {
                Text(
                    text = "Hubungi Saya",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}