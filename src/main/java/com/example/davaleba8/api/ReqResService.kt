package com.example.davaleba8.api


import com.example.davaleba8.api.dto.MyResource
import com.example.davaleba8.api.dto.ReqResData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ReqResService {
    @GET("unknown")
    fun getResources(@Query("page")page: Int): Call<ReqResData<List<MyResource>>>
    @GET("unknown/{resId}")
    fun getResources(@Query("resId")id: Long): Call<ReqResData<MyResource>>
}