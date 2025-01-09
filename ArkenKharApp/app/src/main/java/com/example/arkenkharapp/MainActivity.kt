package com.example.arkenkharapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavHost()
        }
    }
}

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "firstScreen") {
        composable("firstScreen") { FirstScreen(navController) }
        composable("magicScreen") { MagicScreen(navController) }
    }
}

@Composable
fun FirstScreen(navController: NavHostController) {
    var selectedButton by remember { mutableStateOf("main") }

    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        BackgroundImage()
        Column(Modifier.fillMaxSize()) {
            ContentSection(selectedButton, navController)
            BottomBar(selectedButton) { selectedButton = it }
        }
    }
}

@Composable
fun ImageGrid() {
    Box {
        BackgroundImage()
        // Здесь вы можете заменить изображения на свои
        val images = listOf(
            R.drawable.water, R.drawable.earth, R.drawable.fire,
            R.drawable.ice, R.drawable.air, R.drawable.shadow,
            R.drawable.light, R.drawable.time, R.drawable.dark,
            R.drawable.blood, R.drawable.death, R.drawable.curse
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(images.size) { index ->
                ImageItem(imageResId = images[index])
            }
        }
        BottomBar(selectedButton = "") { }
    }
}

@Composable
fun BackgroundImage() {
    Image(
        painter = painterResource(id = R.drawable.bg_all),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
}

@Composable
fun BottomBar(selectedButton: String, onButtonSelected: (String) -> Unit) {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {
        BottomAppBar(containerColor = Color.Transparent) {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                val buttons = listOf("main", "book", "play", "profile")
                buttons.forEach { button ->
                    BottomBarButton(
                        label = button,
                        isSelected = selectedButton == button,
                        onClick = { onButtonSelected(button) }
                    )
                }
            }
        }
    }
}

@Composable
fun BottomBarButton(label: String, isSelected: Boolean, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSelected) Color.Gray else Color.Transparent
        )
    ) {
        Image(
            painter = painterResource(id = when (label) {
                "main" -> R.drawable.ic_main
                "book" -> R.drawable.ic_book
                "play" -> R.drawable.ic_play
                "profile" -> R.drawable.ic_profile
                else -> R.drawable.ic_main
            }),
            contentDescription = null,
            contentScale = ContentScale.FillHeight
        )
    }
}

@Composable
fun ContentSection(selectedButton: String, navController: NavHostController) {
    when (selectedButton) {
        "main" -> MainSection()
        "book" -> BookSection(navController)
        "play" -> PlaySection()
        "profile" -> ProfileSection()
        else -> {}
    }
}

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
                val intent = Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.litres.ru/book/darya-stal/poslednie-magi-70232329/"))
                context.startActivity(intent)
            }).padding(bottom = 20.dp))
        Text(text = "Роман \"Рубиновый орден\"",
            color = Color.White,
            fontSize = 24.sp,
            modifier = Modifier.clickable(onClick = {
                val intent = Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.litres.ru/book/darya-stal/rubinovyy-orden-71346835/"))
                context.startActivity(intent)
            }).padding(bottom = 20.dp))
    }
}

@Composable
fun BookSection(navController: NavHostController) {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text(text = "Магия", Modifier.clickable(onClick = {
            navController.navigate("magicScreen")
        }).padding(bottom = 20.dp),
            color = Color.White,
            fontSize = 24.sp,)
        Text(text = "Места", Modifier.clickable(onClick = { }).padding(bottom = 20.dp),
            color = Color.White,
            fontSize = 24.sp,)
        Text(text = "Существа", Modifier.clickable(onClick = { }).padding(bottom = 20.dp),
            color = Color.White,
            fontSize = 24.sp,)
        Text(text = "Артефакты", Modifier.clickable(onClick = { }).padding(bottom = 20.dp),
            color = Color.White,
            fontSize = 24.sp,)
    }
}

@Composable
fun MagicScreen(navController: NavHostController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Магия", fontWeight = FontWeight.Bold, fontSize = 24.sp)
        ImageGrid()
        Button(onClick = { navController.navigateUp() }) {
            Text("Назад")
        }
    }
}

@Composable
fun PlaySection() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text(text = "В разработке",
            color = Color.White,
            fontSize = 42.sp,)
    }
}

@Composable
fun ProfileSection() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text(text = "В разработке",
            color = Color.White,
            fontSize = 42.sp,)
    }
}

@Composable
fun ImageItem(imageResId: Int) {
    Image(
        painter = painterResource(id = imageResId),
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f) // Сохраняем пропорции
            .clickable { /* Действие при клике */ }
    )
}

@Preview(showBackground = true)
@Composable
fun FirstScreenPreview() {
    FirstScreen(rememberNavController())
}
