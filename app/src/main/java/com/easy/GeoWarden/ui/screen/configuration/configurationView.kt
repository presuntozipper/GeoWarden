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
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.easy.GeoWarden.ui.Theme.theme.GeoWardenTheme
import com.easy.GeoWarden.ui.screen.configuration.components.ConfigScrollable
import com.easy.GeoWarden.ui.screen.home.components.UserAvatar
import com.easy.GeoWarden.ui.screen.home.marineBlue
import kotlinx.coroutines.launch


val gradientColors = Brush.linearGradient(
    colors = listOf(Color.Blue, Color.Black),
    start = Offset(150f, 60f),
    end = Offset(2000f, 3000f)
)


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

            Box(modifier = Modifier.fillMaxSize().background(brush = gradientColors)
                .padding(paddingValues)) {

                Column(modifier = Modifier.fillMaxWidth().fillMaxSize()) {


                    Box(
                        modifier = Modifier.weight(1f).fillMaxHeight().fillMaxWidth().padding(15.dp)
                        //.background(Color.Cyan)

                    ) {

                        //Box da parte de cima
                        Box(
                            modifier = Modifier
                                // .background(Color.Yellow)
                                .padding(12.dp),
                            contentAlignment = Alignment.BottomCenter

                            //.background(Color.Yellow)
                        ) {
                            Box(
                                modifier = Modifier
                                   // .padding(80.dp, 270.dp, 10.dp, 0.dp)
                                    //.background(Color.White)
                            ) {
                                Column(verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally){
                                    Button(onClick = {
                                        if (!isLoggedIn) {
                                            scope.launch {
                                                val result = snackbarHostState.showSnackbar(
                                                    message = "Você precisa estar logado para salvar as configurações.",
                                                    actionLabel = "Login",
                                                    duration = SnackbarDuration.Short
                                                )
                                                if (result == SnackbarResult.ActionPerformed) {
                                                    //onLoginClick()
                                                }
                                            }
                                        } else {
                                            // Lógica para salvar as configurações (para usuários logados)
                                            scope.launch {
                                                snackbarHostState.showSnackbar(
                                                    message = "Configurações salvas com sucesso!",
                                                    duration = SnackbarDuration.Short
                                                )
                                            }
                                        }
                                    }) {
                                        Text("Salvar Configurações")
                                    }
                                    if (!isLoggedIn) {
                                        // Botão visível apenas se não estiver logado
                                        Button(onClick = {}) {
                                            Text("Login")
                                        }
                                    }

                                }


                            }


                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                UserAvatar()
//                                Box(
//                                    modifier = Modifier
//                                        .background(
//                                            color = Color.White,
//                                            shape = RoundedCornerShape(24.dp)
//                                        ), contentAlignment = Alignment.Center
//
//                                ) {
//                                    Image(
//                                        painter = painterResource(id = R.drawable.avatarplaceholder),
//                                        contentDescription = "Avatar",
//                                        modifier = Modifier
//                                            .width(150.dp)
//                                            .height(150.dp),
//
//                                        )
//                                }
                            }


                        }

                    }


                    //Box da parte de Baixo
                    Box(modifier = Modifier.weight(1f).fillMaxHeight().fillMaxWidth()) {


                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(start = 16.dp, end = 16.dp, top = 0.dp, bottom = 50.dp)
                                .background(
                                    color = Color(marineBlue),
                                    shape = RoundedCornerShape(24.dp)
                                )
                        ) {


                            Box(
                                modifier = Modifier.fillMaxSize(),
                                //contentAlignment = Alignment.TopCenter
                            ) {

                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(16.dp)
                                        .verticalScroll(rememberScrollState())
                                    //.background(Color.White)//debug remover dps
                                ){
                                    ConfigScrollable(notification)
                                }
//                                {
//                                    //SnackbarLogin(isLogged = false) { }
//
//                                    Row(
//                                        modifier = Modifier
//                                            .fillMaxWidth()
//                                            .padding(16.dp)
//                                            .background(
//                                                color = Color.White,
//                                                shape = RoundedCornerShape(24.dp)
//                                            ),
//                                        verticalAlignment = Alignment.CenterVertically,
//
//                                        ) {
//
//
//                                        Box(
//                                            modifier = Modifier
//                                                .weight(0.4f)
//                                                .height(65.dp)
//                                                .width(60.dp)
//                                                .padding(20.dp, 10.dp, 0.dp, 0.dp)
//                                        )
//                                        {
//                                            Switch(
//                                                checked = notification.value,
//                                                onCheckedChange = { notification.value = it },
//                                                colors = SwitchDefaults.colors(
//                                                    disabledCheckedThumbColor = Color(0xFFA09D9D),
//                                                    disabledCheckedTrackColor = Color(0xFF5C6661),
//                                                    checkedThumbColor = Color(0xFFFFFFFF),
//                                                    checkedTrackColor = Color(0xFF0DE03B),
//                                                    uncheckedThumbColor = Color(0xFFFF0000),
//                                                    uncheckedTrackColor = Color(0xFF514B6A),
//
//                                                    )
//                                            )
//                                        }
//                                        Box(
//                                            modifier = Modifier.weight(1f).height(65.dp),
//                                            contentAlignment = Alignment.Center
//                                        ) {
//
//                                            Text("newLabel", fontSize = 16.sp, color = Color.Black)
//                                        }
//                                    }
//                                    Row(
//                                        modifier = Modifier
//                                            .fillMaxWidth()
//                                            .padding(16.dp)
//                                            .background(
//                                                color = Color.White,
//                                                shape = RoundedCornerShape(24.dp)
//                                            ),
//                                        verticalAlignment = Alignment.CenterVertically,
//
//                                        ) {
//
//                                        Box(
//                                            modifier = Modifier
//                                                .weight(0.4f)
//                                                .height(65.dp)
//                                                .width(60.dp)
//                                                .padding(20.dp, 10.dp, 0.dp, 0.dp)
//                                        )
//                                        {
//                                            Switch(
//                                                checked = notification.value,
//                                                onCheckedChange = { notification.value = it },
//                                                colors = SwitchDefaults.colors(
//                                                    disabledCheckedThumbColor = Color(0xFFA09D9D),
//                                                    disabledCheckedTrackColor = Color(0xFF5C6661),
//                                                    checkedThumbColor = Color(0xFFFFFFFF),
//                                                    checkedTrackColor = Color(0xFF0DE03B),
//                                                    uncheckedThumbColor = Color(0xFFFF0000),
//                                                    uncheckedTrackColor = Color(0xFF514B6A),
//
//                                                    )
//                                            )
//                                        }
//
//                                        Box(
//                                            modifier = Modifier.weight(1f).height(65.dp),
//                                            contentAlignment = Alignment.Center
//                                        ) {
//
//                                            Text(
//                                                "Notificações",
//                                                fontSize = 16.sp,
//                                                color = Color.Black
//                                            )
//                                        }
//                                    }
//                                }

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
