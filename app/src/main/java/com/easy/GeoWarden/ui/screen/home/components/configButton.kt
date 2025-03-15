package com.easy.GeoWarden.ui.screen.home.components
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


class ConfigButton {

    @Composable
    fun ConfigurationButton() {
        val navController:NavHostController = rememberNavController()

        Button(
            onClick = { navController.navigate(route = "configuration"){popUpTo("home"){inclusive = true} } },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(12.dp)
        ) { Text("Configurações") }

    }
}