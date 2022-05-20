package com.example.davaleba8.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.davaleba8.R
import com.example.davaleba8.adapters.ResourceRecyclerAdapter.Companion.USER_ID
import com.example.davaleba8.api.RestClient
import com.example.davaleba8.api.dto.MyResource
import com.example.davaleba8.api.dto.ReqResData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResourceActivity : AppCompatActivity() {
    private lateinit var nameView: TextView
    private lateinit var yearView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resource)

        nameView = findViewById(R.id.textView3)
        yearView = findViewById(R.id.textView4)
        val userId = intent.extras?.getLong(USER_ID, -1)
        if (userId != -1L){
            RestClient.reqResApi.getResources(userId!!).enqueue(object :
                Callback<ReqResData<MyResource>> {
                override fun onResponse(
                    call: Call<ReqResData<MyResource>>,
                    response: Response<ReqResData<MyResource>>
                ) {
                    if (response.isSuccessful){
                        response.body()?.data?.let {
                            nameView.text = it.name
                            yearView.text = it.year.toString()
                        }
                    }
                }

                override fun onFailure(call: Call<ReqResData<MyResource>>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
        }
    }
}