package com.easy.geoWarden.ui.Navigation

import kotlinx.serialization.Serializable

sealed class  Dest{
    @Serializable
    data object HomeScreen:Dest()
    @Serializable
    data object LoginView:Dest()
    @Serializable
    data object RegisterScreen:Dest()
    @Serializable
    data object ConfigurationView:Dest()
    @Serializable
    data object InitialScreen:Dest()



}