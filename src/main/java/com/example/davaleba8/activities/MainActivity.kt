package com.example.davaleba8.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.davaleba8.adapters.ResourceRecyclerAdapter
import com.example.davaleba8.api.RestClient
import com.example.davaleba8.api.dto.MyResource
import com.example.davaleba8.api.dto.ReqResData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.davaleba8.R

import com.example.davaleba8.api.dto.*

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)

        RestClient.initClient()
        RestClient.reqResApi.getResources(1).enqueue(object : Callback<ReqResData<List<MyResource>>> {
            override fun onResponse(
                call: Call<ReqResData<List<MyResource>>>,
                response: Response<ReqResData<List<MyResource>>>
            ) {
                if(response.isSuccessful){
                    response.body()?.data?.let {
                        recyclerView.adapter = ResourceRecyclerAdapter(it)
                        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                    }
                }
            }

            override fun onFailure(call: Call<ReqResData<List<MyResource>>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}