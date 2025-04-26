package com.easy.GeoWarden.ui.Navigation


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.easy.GeoWarden.ui.screen.InitialScreen
import com.easy.GeoWarden.ui.screen.configuration.ConfigurationView
import com.easy.GeoWarden.ui.screen.home.HomeView
import com.easy.GeoWarden.ui.screen.loginScreen.LoginView


@Composable
fun NavigationGraph(modifier: Modifier){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Dest.InitialScreen) {

        composable<Dest.InitialScreen> {
            InitialScreen {
                navController.navigate(Dest.HomeScreen)
                { popUpTo(Dest.InitialScreen) { inclusive = true } }
            }
        }


        composable<Dest.HomeScreen>{
            HomeView {
                navController.navigate(Dest.ConfigurationView)
            }

        }
        composable<Dest.LoginScreen>{
            LoginView() {
                navController.navigate(Dest.HomeScreen)
                { popUpTo(Dest.LoginScreen) { inclusive = true } }
            }
    }
        composable<Dest.RegisterScreen>{}
        composable<Dest.ConfigurationView>{
            ConfigurationView(){
                navController.navigate(Dest.HomeScreen)
            }
        }

    }

}