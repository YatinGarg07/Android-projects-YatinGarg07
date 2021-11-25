package com.example.roomdemo

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdemo.databinding.ActivityMainBinding.inflate
import com.example.roomdemo.databinding.ListItemBinding
import com.example.roomdemo.db.Subscriber
import com.example.roomdemo.generated.callback.OnClickListener

class MyRecyclerViewAdapter( private  val clickListener : (Subscriber)-> Unit ) : RecyclerView.Adapter<MyViewHolder>() {

    private var subscriberList = ArrayList<Subscriber>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding : ListItemBinding = DataBindingUtil.inflate(inflater,R.layout.list_item,parent,false)

        return MyViewHolder(binding)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(subscriberList[position],clickListener)
    }

    fun setList(subscribers: List<Subscriber>){
        subscriberList.clear()
        subscriberList.addAll(subscribers)
    }

    override fun getItemCount(): Int {
    return subscriberList.size
    }

}

 class MyViewHolder(val binding : ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind (subscriber: Subscriber,clickListener : (Subscriber)-> Unit){
        binding.nameTextView.text = subscriber.name
        binding.emailTextView.text = subscriber.email
        binding.listItemLayout.setOnClickListener {
            clickListener(subscriber)
        }
    }

}