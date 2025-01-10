package com.example.arkenkharapp.ui.elements

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.arkenkharapp.R
import com.example.arkenkharapp.utils.ImageItem

@Composable
fun ImageGrid(modifier: Modifier) {
    Column {
        val images = listOf(
            R.drawable.water, R.drawable.earth, R.drawable.fire,
            R.drawable.ice, R.drawable.air, R.drawable.shadow,
            R.drawable.light, R.drawable.time, R.drawable.dark,
            R.drawable.blood, R.drawable.death, R.drawable.curse
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier.padding(8.dp)
        ) {
            items(images.size) { index ->
                ImageItem(imageResId = images[index])
            }
        }
    }
}