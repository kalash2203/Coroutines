package com.example.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Context will describe in which thread
        // coroutine will be started in
GlobalScope.launch(Dispatchers.IO) {
    Log.d(TAG, "Starting coroutines in thread${Thread.currentThread().name}")
    val answer = doNetworkCall()
    //changing the dispatcher from IO to Main (i.e. context)
    withContext(Dispatchers.Main) {
        Log.d(TAG, "Setting text in thread ${Thread.currentThread().name}")
        tvDummy.text = answer
    } } }
    suspend fun doNetworkCall(): String {
        delay(3000L)
        return "This is the answer"
    }
}