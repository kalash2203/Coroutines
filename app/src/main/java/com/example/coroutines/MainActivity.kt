package com.example.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    val TAG="MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val job= GlobalScope.launch(Dispatchers.Default) {
            repeat(5) {
                Log.d(TAG,"Coroutines is still working...")
                delay(1000L)
            }
        }
        runBlocking {
            delay(2000L)
           //job.join will block the thread untill this(lineNo.15) coroutine is finished
           // job.join()
            job.cancel()
            //used to cancel the job for that we have delayed the main thread lineNo.22
            //cancellation is cooperative which means corutine should be properly setup
            // in order to cancel it.
            Log.d(TAG,"Main thread is continuing")
        }
    }
}