package com.example.davaleba9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager

class MainActivity : AppCompatActivity() {
    

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        val worker1 = OneTimeWorkRequestBuilder<FirstWorker>()
            .build()

        val worker2 = OneTimeWorkRequestBuilder<SecondWorker>()
            .build()

        val worker3 = OneTimeWorkRequestBuilder<ThirdWorker>()
            .build()

        WorkManager.getInstance(this)
            .beginWith(worker1)
            .then(worker2)
            .then(worker3)
            .enqueue()
    }
}