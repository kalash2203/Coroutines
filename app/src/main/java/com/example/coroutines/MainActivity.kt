package com.example.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //coroutine lives as long as the application lives
        GlobalScope.launch {
            //delay function only pause the current coroutine ,it will not block the
            //whole thread.
            //if main thread finishes then coroutine is also cancelled
            delay(3000L)
            Log.d(TAG,"Coroutines says hello from thread${Thread.currentThread().name}")
        }
        Log.d(TAG," hello from thread${Thread.currentThread().name}")
    }
}