package com.easy.GeoWarden.ui.Navigation

import kotlinx.serialization.Serializable

sealed class  Dest{
    @Serializable
    data object HomeScreen:Dest()
    @Serializable
    data object LoginScreen:Dest()
    @Serializable
    data object RegisterScreen:Dest()
    @Serializable
    data object ConfigurationScreen:Dest()
    @Serializable
    data object InitialScreen:Dest()



}