package com.example.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
val TAG="MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //a suspend function will be called inside of a another suspend function or coroutine
        GlobalScope  .launch {
            val networkCallAnswer=doNetworkCall()
            val networkCallAnswer2=doNetworkCall2()
            Log.d(TAG,networkCallAnswer)
            Log.d(TAG,networkCallAnswer2)
        }
    }
    //we can create our own suspend functions outside onCreate function
    //we cannot call a suspend function outside of a coroutine we can call
    //it inside of a coroutine lineNo.
    suspend fun  doNetworkCall(): String {
        delay(3000L)
        return "This is the answer"
    }
    suspend fun  doNetworkCall2(): String {
        delay(3000L)
        return "This is not the answer"
    }
}

