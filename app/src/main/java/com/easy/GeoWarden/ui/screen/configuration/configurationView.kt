package com.easy.GeoWarden.ui.screen.configuration


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.easy.GeoWarden.R
import com.easy.GeoWarden.ui.screen.home.theme.GeoWardenTheme

const val colorBlack: Long = 0xFF000000
const val marineBlue:Long = 0xFF142236

val gradientColors = Brush.linearGradient(
    colors = listOf(Color.Blue, Color.Black),
    start = androidx.compose.ui.geometry.Offset(150f, 60f),
    end = androidx.compose.ui.geometry.Offset(2000f, 3000f)
)

@Composable
fun ConfigurationView(){
    GeoWardenTheme {
        Box(modifier = Modifier.fillMaxSize().background(brush = gradientColors)){

            Column(modifier = Modifier.fillMaxWidth().fillMaxSize()) {

                Box(modifier = Modifier.weight(0.7f).fillMaxHeight().fillMaxWidth().padding(10.dp),
                    contentAlignment = Alignment.BottomCenter){
                    Box(modifier = Modifier.fillMaxSize().padding(80.dp),contentAlignment = Alignment.BottomCenter){
                        Button(onClick = {}, enabled = false, shape = RoundedCornerShape(60.dp)) {Image( painter = painterResource(id = R.drawable.avatarplaceholder), contentDescription = "Avatar") }

                    }
                    Text("Configurações", color = Color.White, fontSize = MaterialTheme.typography.headlineLarge.fontSize)}
                Box(modifier = Modifier.weight(1f).fillMaxHeight().fillMaxWidth()){
                    Box(modifier = Modifier.fillMaxSize().padding(12.dp).background(Color(marineBlue))){

                    }
                   }


            }

        }

    }
}

@Preview(showBackground = true)
@Composable
 fun PreviewConfigurationView(){
     ConfigurationView()
 }
