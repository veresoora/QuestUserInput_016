package com.nadia.input

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun LatihanInput(modifier: Modifier = Modifier) {
    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var noTelpon by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var JK by remember { mutableStateOf("") }

    val listJK = listOf("Laki-Laki", "Perempuan")

    var namasv by remember { mutableStateOf("") }
    var emailsv by remember { mutableStateOf("") }
    var notelponsv by remember { mutableStateOf("") }
    var alamatsv by remember { mutableStateOf("") }
    var JKsv by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
        .padding(top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Biodata", fontSize = 25.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.padding(16.dp))
        TextField(
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            value = nama,
            onValueChange = {nama = it},
            label = {
                Text("Nama")
            },
            placeholder = {
                Text("Masukkan Nama Anda")
            }
        )

        Row {
            listJK.forEach { item ->
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) { RadioButton(
                    selected = JK == item,
                    onClick = {
                        JK = item
                    }
                )
                Text(item)
                }
            }
        }

        TextField(
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            value = email,
            onValueChange = {email = it},
            label = {
                Text("Email")
            },
            placeholder = {
                Text("Masukkan Email Anda")
            }
        )
        TextField(
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            value = noTelpon,
            onValueChange = {noTelpon = it},
            label = {
                Text("Nomor Telepon")
            },
            placeholder = {
                Text("Masukkan Nomor Telepon Anda")
            }
        )
        TextField(
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            value = alamat,
            onValueChange = {alamat = it},
            label = {
                Text("Alamat")
            },
            placeholder = {
                Text("Masukkan Alamat Anda")
            }
        )
        Button(
            onClick = {
                namasv = nama
                emailsv = email
                notelponsv = noTelpon
                alamatsv = alamat
                JKsv = JK
            }
        ) {
            Text("Submit")
        }
        ElevatedCard(
            colors = CardDefaults.cardColors(containerColor = Color.LightGray),
            modifier = Modifier
            .fillMaxWidth()) {
            DetailSurat(judul = "Nama", isinya = namasv)
            DetailSurat(judul = "Jenis Kelamin", isinya = JKsv)
            DetailSurat(judul = "Email", isinya = emailsv)
            DetailSurat(judul = "No Telpon", isinya = notelponsv)
            DetailSurat(judul = "Alamat", isinya = alamatsv)
        }
    }
}

@Composable
fun DetailSurat(
    judul: String, isinya: String
){
    Column(
        modifier = Modifier.fillMaxWidth().padding(16.dp)
    ) {


        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = judul,
                modifier = Modifier.weight(1.2f))

            Text(text = ":",
                modifier = Modifier.weight(0.2f))

            Text(text = isinya,
                modifier = Modifier.weight(2f))

        }
    }
}