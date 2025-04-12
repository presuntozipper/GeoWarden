package com.easy.GeoWarden.ui.screen.home




import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.easy.GeoWarden.ui.Theme.theme.GeoWardenTheme
import com.easy.GeoWarden.ui.Theme.theme.GradientColorBlueToBlack
import com.easy.GeoWarden.ui.Theme.theme.GradientColorLightBlueToDarkBlue2
import com.easy.GeoWarden.ui.Theme.theme.MarineBlue
import com.easy.GeoWarden.ui.screen.home.components.CurrentLocation
import com.easy.GeoWarden.ui.screen.home.components.CurrentLocationCard
import com.easy.GeoWarden.ui.screen.home.components.TopBar
import com.easy.GeoWarden.ui.screen.home.components.UserAvatar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
 fun HomeView( onNavigate:() -> Unit) {
  GeoWardenTheme {
    Box(Modifier
        .fillMaxSize()
        .background(brush = GradientColorBlueToBlack)) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(850.dp)
                .padding(16.dp,36.dp,16.dp,10.dp)
                .background(color = Color(MarineBlue.value),
            shape = RoundedCornerShape(24.dp))
        ) {
            Column(modifier = Modifier){
                Box(modifier = Modifier
                    .fillMaxWidth(1f)
                    .height(85.dp)
                    //Barra do topo da Aplicação
                ) { TopBar(onNavigate = onNavigate){} }
                //Box da localização atual
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(32.dp)
                    ,contentAlignment = Alignment.BottomCenter){
                    Text(text = CurrentLocation,color = Color.White, fontSize = 20.sp)
                }
                //Box Com card da localização atual
                Box(modifier = Modifier.fillMaxWidth()){ CurrentLocationCard() }
                //Criador de Coleção de Locais

                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .padding(16.dp)
                    .background(brush = GradientColorLightBlueToDarkBlue2
                        , shape = RoundedCornerShape(24.dp))
                ){
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
                    ){
                        item (span = { GridItemSpan(maxLineSpan) }){
                            Text(text = "Localizações", color = Color.White, fontSize = 20.sp)
                        }
                        items(6){test -> UserAvatar() }
                    }
                }
              }
            }
        }
    }
  }


@Preview(showBackground = true)
@Composable
fun HomeViewPreview(){
    HomeView(onNavigate = {})
}
