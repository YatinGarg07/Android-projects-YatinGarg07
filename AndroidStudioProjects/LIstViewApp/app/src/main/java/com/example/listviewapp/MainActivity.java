package com.example.listviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String arr[]={"This is " , "Nobita" , "Shizuka"," okji" ,"lop","lop","lop","jio","lop"};

        listview=findViewById(R.id.list_View);
        //USing built in array adapter
       ArrayAdapter ad = new ArrayAdapter<String>(this , android.R.layout.simple_list_item_2,android.R.id.text2,arr);
//        listview.setAdapter(ad);
 //       YatinAdapter ad= new YatinAdapter(this , R.layout.mylayout,arr);
        listview.setAdapter(ad);
//        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity.this,"You clicked on this : "+position,Toast.LENGTH_SHORT).show();
//            }
//        });

    }
}