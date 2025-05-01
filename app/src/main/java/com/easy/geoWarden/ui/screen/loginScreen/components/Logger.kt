package com.easy.geoWarden.ui.screen.loginScreen.components

import androidx.compose.runtime.Composable
import com.easy.geoWarden.ui.screen.loginScreen.LoginViewModel


@Composable
fun Loggin(email: String, password: String, viewModel: LoginViewModel = LoginViewModel()) {

    suspend {  viewModel.login(email,password) }
}


