package com.example.bus_timetable_okhttp_kotlin_application

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.GsonBuilder
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        fetchJson()
    }

    fun fetchJson() {
        println("hello")

//        val url = "https://data.smartdublin.ie/cgi-bin/rtpi/realtimebusinformation?stopid=1187&format=json"
        val url = "https://api.letsbuildthatapp.com/youtube/home_feed"

        val request = Request.Builder().url(url).build()

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
               // }
            }
        })
    }
}

//class HomeFeed(val results: List<Results>)
//
//class Results(val scheduledarrivaldatetime: String)

class HomeFeed(val videos: List<Video>)

class Video(val id: Int, val name: String)