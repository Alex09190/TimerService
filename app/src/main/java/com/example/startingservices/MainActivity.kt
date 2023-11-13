package com.example.startingservices

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.text.Editable
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTimeText = findViewById<EditText>(R.id.editTimeText)
        val startButton = findViewById<Button>(R.id.startButton)



        startButton.setOnClickListener {
            val intent = Intent (this, TimerService::class.java)
            intent.putExtra("TIMER_VALUE", editTimeText.text.toString().toIntOrNull())
            startService(intent)

            //timerBinder.start(editTimeText.text))
            //editTimeText.text.toInt()
        }
    }
}



