package com.example.kotlinfishermanhandbook

import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MyAdapter(listArray: ArrayList<ListItem>, context: Context): RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    var listArrayR =listArray
    var contextR = context

    class ViewHolder (view: View): RecyclerView.ViewHolder(view){
        val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
        val tvContent = view.findViewById<TextView>(R.id.tvContent)
        val im = view.findViewById<ImageView>(R.id.im)
        fun bind(listItem: ListItem, context: Context){
            tvTitle.text = listItem.titleText
            tvContent.text = listItem.ContentText
            im.setImageResource(listItem.image_id)
            itemView.setOnClickListener(){
                Toast.makeText(context, "Pressed : ${tvTitle. text}", Toast.LENGTH_SHORT).show()
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(contextR)
        return ViewHolder(inflater.inflate(R.layout.item_layout,parent,false))
    }

    override fun getItemCount(): Int {
        return listArrayR.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var listItem =listArrayR.get(position)
        holder.bind(listItem,contextR)
    }
    fun updateAdapter(listArray: List<ListItem>){
        listArrayR.clear()
        listArrayR.addAll(listArray)
        notifyDataSetChanged()
    }
}