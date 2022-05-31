package com.example.davaleba9

import android.content.Context
import android.util.Log
import android.widget.TextView
import androidx.work.Worker
import androidx.work.WorkerParameters

class SecondWorker (ctx: Context, params: WorkerParameters) : Worker(ctx, params) {

    override fun doWork(): Result {

        doSomething(this.javaClass.name, 2)

        val intArray = inputData.getIntArray("KEY");

        for (element in intArray!!) {
            println("num: $element")
        }

        return Result.success();
    }

}