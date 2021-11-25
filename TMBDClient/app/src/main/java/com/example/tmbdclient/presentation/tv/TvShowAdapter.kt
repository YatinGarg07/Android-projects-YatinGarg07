package com.example.tmbdclient.presentation.tv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmbdclient.R
import com.example.tmbdclient.data.model.tvshow.TvShow
import com.example.tmbdclient.databinding.ListItemBinding


class TvShowAdapter : RecyclerView.Adapter<MyViewHolder>() {
    private var tvShowsList =ArrayList<TvShow>()

    fun setList(tvShows : List<TvShow>){
        tvShowsList.clear()
        tvShowsList.addAll(tvShows)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ListItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item,parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(tvShowsList[position])
    }

    override fun getItemCount(): Int {
        return tvShowsList.size
    }

}

class MyViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root){

    fun bind(tvShow :TvShow){
        binding.titleTextView.text = tvShow.name
        binding.descriptionTextView.text = tvShow.overview
        val posterURL = "https://image.tmdb.org/t/p/w500/"+tvShow.posterPath
        Glide.with(binding.imageView.context).
        load(posterURL)
            .into(binding.imageView)
    }

}