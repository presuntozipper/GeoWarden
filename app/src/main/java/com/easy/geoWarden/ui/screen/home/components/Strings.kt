package com.easy.geoWarden.ui.screen.home.components


const val version:String = "V0.0.1"
const val AppName:String = "GeoWarden"
const val Notification:String = "Notificações"
const val CurrentLocation:String = "Localização atual"

fun getTemp(temp: Int):String{
        val tempString = temp.toString()

    return tempString
}