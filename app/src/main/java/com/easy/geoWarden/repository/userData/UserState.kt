package com.easy.geoWarden.repository.userData

sealed class UserState {

    object noLogin:UserState()


    data class LoggedIn(val userData: Any? = null):UserState()
    data class Error(val message:String):UserState()
}
