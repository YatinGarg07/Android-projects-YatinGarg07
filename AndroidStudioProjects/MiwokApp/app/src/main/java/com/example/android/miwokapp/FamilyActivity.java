package com.example.android.miwokapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);
        ArrayList<Word> colors=new ArrayList<>();
        colors.add(new Word("red" ,"weṭeṭṭi"));
        colors.add(new Word("green" ,"chokokki"));
        colors.add(new Word("brown" ,"ṭakaakki"));
        colors.add(new Word("gray" ,"ṭopoppi"));
        colors.add(new Word("black" ,"kululli"));
        colors.add(new Word("white" ,"kelelli"));
        colors.add(new Word("dusty yellow" ,"ṭopiisә"));
        colors.add(new Word("mustard yellow" ,"chiwiiṭә"));


        WordAdapter<Word> itemsAdapter = new WordAdapter<Word>(this, colors);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
    }
}