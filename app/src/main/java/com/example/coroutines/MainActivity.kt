package com.example.coroutines

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    val TAG="MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStartActivity.setOnClickListener {
            //lifecycle scope ensures that if activity is destroyed then all the coroutines associated with this activity will also be destroyed,if there is globalscope then
            //coroutine will be running and using the resources and can lead to
            //memory leaks and resources will not be garbage collected.
         lifecycleScope.launch{
           while(true)   {
               delay(1000L)
               Log.d(TAG,"Still running...")
           }
         }
            GlobalScope.launch {
                delay(5000L)
                Intent(this@MainActivity,SecondActivity::class.java).also {
                    startActivity(it)
                    finish()
                }
            }
        }
    }
}