package com.easy.GeoWarden.ui.screen.home.components

import androidx.compose.material3.Button
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun SaveLoginButton(snackbarHostState: SnackbarHostState, scope: CoroutineScope, isLoggedIn: Boolean){


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