 package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding

 class MainActivity : AppCompatActivity() , INotesRVAdapter {
    private lateinit var viewModel: NoteViewModel
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.lifecycleOwner = this
        viewModel = ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)).
        get(NoteViewModel::class.java)

        //recyclerview
        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = NotesRVAdapter(this , this)
        recyclerView.adapter = adapter

        //observing live data
        viewModel.allNotes.observe(this, Observer { list ->
            list?.let {
                adapter.updateList(it)
            }
        })

        binding.insertButton.setOnClickListener {
            submitData()
        }

    }

     override fun onItemClicked(note: Note) {
         viewModel.deleteNode(note)
         Toast.makeText(this,"${note.text} Deleted",Toast.LENGTH_SHORT).show()
     }

     fun submitData(){
         val noteText =binding.input.text.toString()
         if(noteText.isNotEmpty()) {
             viewModel.insertNote(Note(noteText))
             Toast.makeText(this,"$noteText Inserted",Toast.LENGTH_SHORT).show()
         }
     }
}