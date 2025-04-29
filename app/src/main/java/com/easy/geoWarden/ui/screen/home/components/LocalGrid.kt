package com.easy.geoWarden.ui.screen.home.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp

@Composable

fun LocalGrid( size: Int){
    LazyVerticalGrid(
        columns = object : GridCells {
            override fun Density.calculateCrossAxisCellSizes(
                availableSize: Int,
                spacing: Int
            ): List<Int> {
                val firstColumn = (availableSize - spacing) / 2
                val secondColumn = availableSize - spacing - firstColumn
                return listOf(firstColumn, secondColumn)
            }
        }
        , contentPadding = androidx.compose.foundation.layout.PaddingValues(4.dp)
    ){
        items(size)
        {
            cards ->
            Box(modifier = Modifier.fillMaxWidth()){
                LocationsCard()
                Spacer(modifier = Modifier.height(1.dp))
            }

        }

    }
}