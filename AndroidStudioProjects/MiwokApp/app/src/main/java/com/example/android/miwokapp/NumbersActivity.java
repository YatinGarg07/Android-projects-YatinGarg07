package com.example.android.miwokapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        ArrayList<Word> words=new ArrayList<>();
        words.add(new Word("one" ,"lutti"));
        words.add(new Word("Two" ,"ottiko"));
        words.add(new Word("Three" ,"tolookosu"));
        words.add(new Word("Four" ,"oyyisa"));
        words.add(new Word("Five" ,"masokka"));
        words.add(new Word("Six" ,"temmoka"));
        words.add(new Word("Seven" ,"kenekaku"));
        words.add(new Word("Eight" ,"kawinta"));
        words.add(new Word("Nine" ,"wo'e"));
        words.add(new Word("Ten" ,"na'accha"));

        WordAdapter<Word> itemsAdapter = new WordAdapter<Word>(this, words);

        ListView listView = (ListView) findViewById(R.id.family_trans);
        listView.setAdapter(itemsAdapter);


    }
}