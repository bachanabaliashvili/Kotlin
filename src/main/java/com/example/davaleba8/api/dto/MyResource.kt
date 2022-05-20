package com.example.davaleba8.api.dto

import com.google.gson.annotations.SerializedName

data class ReqResData<T> (
    val page: Int?,
    @SerializedName("per_page")
    val perPage: Int?,
    val total: Int?,
    @SerializedName("total_page")
    val totalPage: Int?,
    val data: T?,
)

data class MyResource (
    val id: Long?,
    val name: String?,
    val year: Int?,
)