package com.example.contactapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recycler;
    private String dataName[]={"Vaibhav Garg" , "Yatin Garg" , "Anil garg","Vaibhav Garg" ,
            "Yatin Garg" , "Anil garg","Vaibhav Garg" , "Yatin Garg" , "Anil garg","Vaibhav Garg" , "Yatin Garg" , "Anil garg",
            "Vaibhav Garg" , "Yatin Garg" , "Anil garg"};
    private String dataphone[]={"7986770315" , "9878102994", "9988873201","7986770315" , "9878102994",
            "9988873201","7986770315" , "9878102994", "9988873201","7986770315" , "9878102994", "9988873201",
            "7986770315" , "9878102994", "9988873201"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler=findViewById(R.id.recyclerView);
        CustomAdapter phoneBook= new CustomAdapter(dataName,dataphone);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(phoneBook);
    }
}