package com.easy.GeoWarden.ui.screen.configuration.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch

// Certifique-se de importar corretamente

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun SnackbarLogin(isLogged:Boolean, onLogin:()->Unit){
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        //topBar = { TopAppBar(title = { Text("Configurações") }) } // Assumindo uma TopAppBar
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
                Button(onClick = {
                    if (!isLogged) {
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
                if (!isLogged) {
                    // Botão visível apenas se não estiver logado
                    Button(onClick = {}) {
                        Text("Login")
                    }
                }
            }
        }
    }
