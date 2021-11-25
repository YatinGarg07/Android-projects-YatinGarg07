package com.example.recyclerviewdemo1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
   private val fruits : List<Fruits> = listOf (Fruits("Mango","Tom") , Fruits("Apple","Joe") ,
       Fruits("Banana","Mark") , Fruits("Guava","Mike") ,Fruits("Seb","Peter"))
    private lateinit var recyclerView : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.my_recycler_view)
        recyclerView.setBackgroundColor(Color.YELLOW)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MyRecyclerViewAdapter(fruits) { selectedFruitItem: Fruits ->
            listItemClicked(
                selectedFruitItem
            )
        }


    }

    private fun listItemClicked(fruit : Fruits){
        Toast.makeText(this,"Supplier name is ${fruit.supplier}",Toast.LENGTH_SHORT).show()
    }

}