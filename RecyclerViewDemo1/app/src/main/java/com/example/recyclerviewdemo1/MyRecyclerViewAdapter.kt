package com.example.recyclerviewdemo1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerViewAdapter(private val fruits : List<Fruits>, private val clickedListener:(Fruits)->Unit) : RecyclerView.Adapter<MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
    val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item,parent,false)

        return MyViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(fruits[position],clickedListener)
    }

    override fun getItemCount(): Int {
        return 5
    }
}

class MyViewHolder(val view: View) :RecyclerView.ViewHolder(view) {

    fun bind (fruits : Fruits , clickedListener:(Fruits)->Unit) {
        view.findViewById<TextView>(R.id.name_text_view).text = fruits.name + "   " +fruits.supplier

        view.setOnClickListener{
            clickedListener(fruits)
        }

    }

}