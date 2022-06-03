package com.example.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    val TAG="MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //runBlocking will start a new coroutine in main thread and will block the main thread

        Log.d(TAG,"Before runBlocking")
        runBlocking {
            Log.d(TAG,"Start of runBlocking")
            delay(5000L)
            Log.d(TAG,"End of runBlocking")
        }
        Log.d(TAG,"After runBlocking")
    }
}
