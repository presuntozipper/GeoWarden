package com.easy.GeoWarden.ui.screen.home



import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.easy.GeoWarden.R
import com.easy.GeoWarden.ui.screen.home.theme.GeoWardenTheme

val gradientColors = Brush.linearGradient(
    colors = listOf(Color.Blue, Color.Black),
    start = androidx.compose.ui.geometry.Offset(150f, 60f),
    end = androidx.compose.ui.geometry.Offset(2000f, 3000f)
)
val version:String = "V0.0.1"
const val marineBlue:Long = 0xFF142236
@Composable
 fun HomeView(modifier: Modifier = Modifier, onNavigate:() -> Unit) {
  GeoWardenTheme {
    Box(Modifier
        .fillMaxSize()
        .background(brush = gradientColors)) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(850.dp)
                .padding(16.dp,36.dp,16.dp,0.dp)
                .background(color = Color(marineBlue), shape = RoundedCornerShape(0.dp))
        ) {
            Box(modifier = Modifier
                .fillMaxWidth(1f)
                .height(85.dp),

            )
            {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(24.dp)),
                    verticalAlignment = Alignment.CenterVertically,



                ) {
                    // Primeiro Box
                    Box(
                        modifier = Modifier
                            .weight(0.9f)
                            .height(65.dp),
                        contentAlignment = Alignment.TopCenter
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.iconsplash),
                            contentDescription = "App Icon"
                        )
                    }

                    // Segundo Box
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(65.dp),

                    ) {
                        Box(modifier = Modifier.fillMaxWidth().height(30.dp),
                            contentAlignment = Alignment.Center

                        ){
                            Text(
                            text = "GeoWardenAPP ",
                            fontSize = 14.sp,
                            softWrap = true,
                            lineHeight = 16.sp,
                            color = Color.Black
                        )}
                        Box(modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(0.dp,10.dp,0.dp,0.dp)
                            ,
                            contentAlignment = Alignment.Center){
                            Text(
                            text = version ,
                            fontSize = 14.sp,
                            softWrap = true,
                            lineHeight = 14.sp,
                            color = Color.Black)}

                    }

                    // Terceiro Box
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(65.dp),

                        contentAlignment = Alignment.Center

                    ) {
                        Box(
                           modifier = Modifier.fillMaxSize()

                        ) {
                            Button(modifier = Modifier.fillMaxSize(),
                                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                                shape = RoundedCornerShape(0),
                                onClick = ({ onNavigate() }),
                                contentPadding = androidx.compose.foundation.layout.PaddingValues(0.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.avatarplaceholder),
                                    contentDescription = "AvatarIcon"
                                )
                            }

                        }


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
    val modifier = Modifier
    HomeView(modifier = modifier, onNavigate = {})
}
