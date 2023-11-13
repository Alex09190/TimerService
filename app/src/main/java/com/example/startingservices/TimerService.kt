package com.example.startingservices

import android.app.Service
import android.content.ComponentName
import android.content.Intent
import android.os.Binder
import android.os.Handler
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class TimerService : Service() {

    private val serviceScope = CoroutineScope(Dispatchers.Main)


    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        //return super.onStartCommand(intent, flags, startId)
        val countDownValue = intent?.getIntExtra("TIMER_VALUE", 10)
        countDownValue?.let { startCountDown(it) }
        return START_NOT_STICKY

    }

    private fun startCountDown(time: Int) {
        serviceScope.launch {
            for (i in time downTo 1) {
                Log.d("CountService", "CountDown: $i")
                delay(1000)
            }
            Log.d("CountServiceDone", "CountDown: Done")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TimerService status", "Destroyed")
    }


}
