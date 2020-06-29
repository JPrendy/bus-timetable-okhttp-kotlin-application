package com.example.bus_timetable_okhttp_kotlin_application

import android.app.Application

open class Url : Application() {

     open fun getBaseUrl(): String {
        return "https://data.smartdublin.ie/cgi-bin/rtpi/realtimebusinformation?stopid=1187&format=json"
    }
}