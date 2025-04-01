package com.easy.GeoWarden.ui.screen.configuration.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable

fun ConfigScrollable(notification: MutableState<Boolean>){

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(24.dp)
                ),
            verticalAlignment = Alignment.CenterVertically,

            ) {


            Box(
                modifier = Modifier
                    .weight(0.4f)
                    .height(65.dp)
                    .width(60.dp)
                    .padding(20.dp, 10.dp, 0.dp, 0.dp)
            )
            {
                Switch(
                    checked = notification.value,
                    onCheckedChange = { notification.value = it },
                    colors = SwitchDefaults.colors(
                        disabledCheckedThumbColor = Color(0xFFA09D9D),
                        disabledCheckedTrackColor = Color(0xFF5C6661),
                        checkedThumbColor = Color(0xFFFFFFFF),
                        checkedTrackColor = Color(0xFF0DE03B),
                        uncheckedThumbColor = Color(0xFFFF0000),
                        uncheckedTrackColor = Color(0xFF514B6A),

                        )
                )
            }
            Box(
                modifier = Modifier.weight(1f).height(65.dp),
                contentAlignment = Alignment.Center
            ) {

                Text("newLabel", fontSize = 16.sp, color = Color.Black)
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(24.dp)
                ),
            verticalAlignment = Alignment.CenterVertically,

            ) {

            Box(
                modifier = Modifier
                    .weight(0.4f)
                    .height(65.dp)
                    .width(60.dp)
                    .padding(20.dp, 10.dp, 0.dp, 0.dp)
            )
            {
                Switch(
                    checked = notification.value,
                    onCheckedChange = { notification.value = it },
                    colors = SwitchDefaults.colors(
                        disabledCheckedThumbColor = Color(0xFFA09D9D),
                        disabledCheckedTrackColor = Color(0xFF5C6661),
                        checkedThumbColor = Color(0xFFFFFFFF),
                        checkedTrackColor = Color(0xFF0DE03B),
                        uncheckedThumbColor = Color(0xFFFF0000),
                        uncheckedTrackColor = Color(0xFF514B6A),

                        )
                )
            }

            Box(
                modifier = Modifier.weight(1f).height(65.dp),
                contentAlignment = Alignment.Center
            ) {

                Text(
                    "Notificações",
                    fontSize = 16.sp,
                    color = Color.Black
                )
            }
        }

}

@Preview(showBackground = true)
@Composable
fun PreviewConfigScrollable(){

   val notification: MutableState<Boolean> = androidx.compose.runtime.mutableStateOf(false)
    ConfigScrollable(notification = notification)
}