package com.example.davaleba9

import android.content.Context
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters

class FirstWorker(ctx: Context, params: WorkerParameters) : Worker(ctx, params) {
    override fun doWork(): Result {
        doSomething(this.javaClass.name, 1)

        val array = intArrayOf(3, 6, 12, 56, 7, 76, 23, 45, 67, 23, 45)

        val data = Data.Builder()
            .putIntArray("KEY", array)
            .build()

        return Result.success(data);
    }
}