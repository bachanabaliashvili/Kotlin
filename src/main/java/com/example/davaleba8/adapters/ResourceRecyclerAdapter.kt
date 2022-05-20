package com.example.davaleba8.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.davaleba8.R
import com.example.davaleba8.activities.ResourceActivity
import com.example.davaleba8.api.dto.MyResource
import android.content.Intent as Intent1

class ResourceRecyclerAdapter(private val myRes: List<MyResource>): RecyclerView.Adapter<ResourceRecyclerAdapter.ResourceViewHolder>() {
    companion object {
        const val USER_ID = "USER_ID"
    }
    class ResourceViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{

        init {
            itemView.setOnClickListener(this)
        }

        private val nameView: TextView = itemView.findViewById(R.id.textView)
        private val yearView: TextView = itemView.findViewById(R.id.textView2)
        private lateinit var myResource: MyResource

        fun onBind(myResource: MyResource){
            nameView.text = myResource.name
            yearView.text = myResource.year.toString()
        }

        override fun onClick(clickedView: View?) {
            val context = itemView.context
            val intent = Intent1(context, ResourceActivity::class.java)
            intent.putExtra(USER_ID, myResource.id)
            context.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResourceViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_res, parent, false)
        return ResourceViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ResourceViewHolder, position: Int) {
        holder.onBind(myRes[position])
    }

    override fun getItemCount(): Int {
        return myRes.size
    }
}