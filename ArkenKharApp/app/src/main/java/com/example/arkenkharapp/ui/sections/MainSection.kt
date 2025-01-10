package com.example.arkenkharapp.ui.sections

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun MainSection() {
    val context = LocalContext.current
    Column(modifier = Modifier.padding(horizontal = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text(text = "Добро пожаловать в приложение Аркен Хар!",
            color = Color.White,
            fontSize = 42.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 20.dp))
        Text(text = "Рассказ \"Последние маги\"",
            color = Color.White,
            fontSize = 24.sp,
            modifier = Modifier.clickable(onClick = {
                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.litres.ru/book/darya-stal/poslednie-magi-70232329/"))
                context.startActivity(intent)
            }).padding(bottom = 20.dp))
        Text(text = "Роман \"Рубиновый орден\"",
            color = Color.White,
            fontSize = 24.sp,
            modifier = Modifier.clickable(onClick = {
                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.litres.ru/book/darya-stal/rubinovyy-orden-71346835/"))
                context.startActivity(intent)
            }).padding(bottom = 20.dp))
    }
}