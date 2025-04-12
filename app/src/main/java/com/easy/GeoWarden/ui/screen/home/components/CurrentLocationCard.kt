package com.easy.GeoWarden.ui.screen.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.easy.GeoWarden.R
import com.easy.GeoWarden.ui.Theme.theme.GradientColorLightBlueToDarkBlue

@Composable
fun CurrentLocationCard(){

    Box(modifier = Modifier
        .fillMaxWidth()
        .height(200.dp)
        .padding(16.dp)
        .background(brush = GradientColorLightBlueToDarkBlue
            ,shape = RoundedCornerShape(24.dp))

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(8.dp)
                .background(
                    brush = GradientColorLightBlueToDarkBlue,
                    shape = RoundedCornerShape(24.dp)
                ), verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(100.dp), contentAlignment = Alignment.Center
            ) {
                //Este Valor para Text vai ser gerado apartir da ViewModel
                Text(text = getTemp(32) + "°", color = Color.White, fontSize = 100.sp)
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(140.dp), contentAlignment = Alignment.Center
            ) {
                Column(modifier = Modifier.fillMaxSize()) {
                    Image(
                        imageVector = ImageVector.vectorResource(id = R.drawable.sunny),
                        contentDescription = "imagem",
                        modifier = Modifier.fillMaxWidth().height(75.dp)
                    )
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        //Este valor será alterado pela viewModel
                        Text(text = "nublado", color = Color.White, fontSize = 25.sp)
                    }
                    Row(
                        modifier = Modifier.height(35.dp).fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(text = "0 " + "% ", color = Color.White, fontSize = 25.sp)
                        Image(
                            imageVector = ImageVector.vectorResource(id = R.drawable.weather_hail),
                            contentDescription = "imagem",
                            modifier = Modifier.height(75.dp)
                        )
                    }

                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCurrentLocationCard(){
    CurrentLocationCard()
}