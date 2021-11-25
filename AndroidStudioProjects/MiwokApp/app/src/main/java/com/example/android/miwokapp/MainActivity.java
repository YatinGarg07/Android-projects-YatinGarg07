package com.example.android.miwokapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView numbersTextView=(TextView) findViewById(R.id.numbers_textView);
        TextView FamilyTextView=(TextView) findViewById(R.id.family_textView);
        TextView colorsTextView=(TextView) findViewById(R.id.colors_textView);
        TextView phrasesTextView=(TextView) findViewById(R.id.phrases_textView);
        numbersTextView.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View view){
            Intent intent= new Intent(MainActivity.this,NumbersActivity.class);
            startActivity(intent);
            }

        });
        FamilyTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this ,FamilyActivity.class);
                startActivity(intent);
            }
        });
        colorsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this ,ColorsActivity.class);
                startActivity(intent);
            }
        });
        phrasesTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this ,PhrasesActivity.class);
                startActivity(intent);
            }
        });
    }



}