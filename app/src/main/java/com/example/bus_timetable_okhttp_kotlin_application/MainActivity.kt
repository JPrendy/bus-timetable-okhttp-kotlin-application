package com.example.bus_timetable_okhttp_kotlin_application

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.GsonBuilder
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener(){

            fetchJson()
        }

    }

    fun fetchJson() {
        println("hello")

        //
        // val testUrl = "https://api.letsbuildthatapp.com/youtube/home_feed"

        val request = Request.Builder().url(Url().getBaseUrl()).build()

        val client = OkHttpClient()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
//                response.use {
//                    if (!response.isSuccessful) throw IOException("Unexpected code $response")

                    for ((name, value) in response.headers) {
                        println("$name: $value")
                    }

//                    println(response.body!!.string())
                    val body = response.body!!.string()

                    val gson = GsonBuilder().create()

                    val homeFeed = gson.fromJson(body, HomeFeed:: class.java)

                    runOnUiThread {
                        val video = homeFeed.results.get(0)
                        val test = video.duetime
                        val text = findViewById<TextView>(R.id.ok)
                        text.text = "the next bus is due $test minutes"
                    }
                // }
            }
        })
    }
}

//{
//    "errorcode": "0",
//    "errormessage": "",
//    "numberofresults": 2,
//    "stopid": "1187",
//    "timestamp": "28/06/2020 18:02:59",
//    "results": [
//    {
//        "arrivaldatetime": "28/06/2020 18:17:00",
//        "duetime": "14",
//        "departuredatetime": "28/06/2020 18:17:00",
//        "departureduetime": "14",
//        "scheduledarrivaldatetime": "28/06/2020 18:19:00",
//        "scheduleddeparturedatetime": "28/06/2020 18:19:00",
//        "destination": "Beaumont",
//        "destinationlocalized": "Beaumont",
//        "origin": "Dundrum",
//        "originlocalized": "Dundrum",
//        "direction": "Inbound",
//        "operator": "bac",
//        "operatortype": "1",
//        "additionalinformation": "",
//        "lowfloorstatus": "no",
//        "route": "14",
//        "sourcetimestamp": "28/06/2020 17:58:04",
//        "monitored": "true"
//    },

class HomeFeed(val results: List<Results>)

class Results(val duetime: String)


//class HomeFeed(val videos: List<Video>)
//class Video(val id: Int, val name: String)