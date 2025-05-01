package com.easy.geoWarden.ui.screen.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.easy.GeoWarden.R

@Composable
fun UserAvatar(){


        Box(
            modifier = Modifier
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(24.dp)
                ), contentAlignment = Alignment.Center

        ) {
            Image(
                painter = painterResource(id = R.drawable.avatarplaceholder),
                contentDescription = "Avatar",
                modifier = Modifier
                    .width(150.dp)
                    .height(150.dp),

                )
        }



}
