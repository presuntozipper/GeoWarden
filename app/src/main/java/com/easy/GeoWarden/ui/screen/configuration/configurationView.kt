package com.easy.GeoWarden.ui.screen.configuration




import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.easy.GeoWarden.ui.Theme.theme.GeoWardenTheme
import com.easy.GeoWarden.ui.Theme.theme.GradientColorBlueToBlack
import com.easy.GeoWarden.ui.Theme.theme.MarineBlue
import com.easy.GeoWarden.ui.screen.configuration.components.ConfigScrollable
import com.easy.GeoWarden.ui.screen.home.components.SaveLoginButton
import com.easy.GeoWarden.ui.screen.home.components.UserAvatar

@Composable
fun ConfigurationView() {
    val notification = remember { mutableStateOf(false) }
    val isLoggedIn = false
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    //Repensar como o snackbar deve ser implementado.1
    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { paddingValues ->
        GeoWardenTheme {

            Box(modifier = Modifier.fillMaxSize().background(brush = GradientColorBlueToBlack)
                .padding(paddingValues)) {

                Column(modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxSize()) {


                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .fillMaxWidth()
                            .padding(15.dp)
                    ) {

                        //Box da parte de cima
                        Box(
                            modifier = Modifier
                                .padding(12.dp),
                            contentAlignment = Alignment.BottomCenter
                        ) {
                            Box(
                                modifier = Modifier
                            ) {
                                Column(verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally)
                                {
                                    SaveLoginButton(snackbarHostState, scope, isLoggedIn)
                                }

                            }


                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) { UserAvatar() }
                        }

                    }


                    //Box da parte de Baixo
                    Box(modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .fillMaxWidth())
                    {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(start = 16.dp, end = 16.dp, top = 0.dp, bottom = 50.dp)
                                .background(
                                    color = Color(MarineBlue.value),
                                    shape = RoundedCornerShape(24.dp)
                                )
                        ) {
                            Box(
                                modifier = Modifier.fillMaxSize()
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(16.dp)
                                        .verticalScroll(rememberScrollState())
                                ){
                                    ConfigScrollable(notification)
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
 fun PreviewConfigurationView(){
     ConfigurationView()
 }
