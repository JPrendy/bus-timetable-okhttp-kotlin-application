package com.example.bus_timetable_okhttp_kotlin_application

class UrlTestApp : Url() {

    var url = "http://127.0.0.1:8080"

    override fun getBaseUrl(): String {
        return url
    }
}