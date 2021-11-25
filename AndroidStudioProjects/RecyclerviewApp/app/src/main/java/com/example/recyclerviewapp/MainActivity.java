 package com.example.recyclerviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    RecyclerView recycler;
    String arr[]={"Item 1","Item 2","Item 3","Item 4","Item 5"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler =findViewById(R.id.recyclerView);
        CustomAdapter yatin =new CustomAdapter(arr);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(yatin);
    }
}