package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemNoteBinding

class NotesRVAdapter(val context: Context, val listener: INotesRVAdapter) : RecyclerView.Adapter<NoteViewHolder>() {

        val allNotes =ArrayList<Note>()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
                val inflater = LayoutInflater.from(context)
                val binding = DataBindingUtil.inflate<ItemNoteBinding>(inflater,R.layout.item_note,parent,false)
                val noteViewHolder = NoteViewHolder(binding)
                noteViewHolder.deleteButton.setOnClickListener{
                        listener.onItemClicked(allNotes[noteViewHolder.adapterPosition])
                }
                return  noteViewHolder
        }

        override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.textView.text = allNotes[position].text
        }

        override fun getItemCount(): Int {
        return allNotes.size
        }

        fun updateList(newList : List<Note>){
                allNotes.clear()
                allNotes.addAll(newList)
                notifyDataSetChanged()
        }
}

class NoteViewHolder(binding : ItemNoteBinding ) : RecyclerView.ViewHolder(binding.root){
        var textView = binding.text
        val deleteButton = binding.deleteButton
}

interface  INotesRVAdapter{
        fun onItemClicked(note:Note)
}

