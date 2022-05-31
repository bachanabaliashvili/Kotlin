package com.example.davaleba9

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class ThirdWorker (ctx: Context, params: WorkerParameters) : Worker(ctx, params) {
    override fun doWork(): Result {
        doSomething(this.javaClass.name, 3)
        return Result.success();
    }
}