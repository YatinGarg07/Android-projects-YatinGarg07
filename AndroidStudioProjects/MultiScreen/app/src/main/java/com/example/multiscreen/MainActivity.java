package com.example.multiscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name;
    String nameText;
    public static final String EXTRA_NAME = "com.example.multiscreen.extra.name";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"This is the second activity",Toast.LENGTH_SHORT).show();//Toast
                Intent intent = new Intent(MainActivity.this , MainActivity2.class);
                name = findViewById(R.id.nameo);
                nameText = name.getText().toString();
                intent.putExtra("EXTRA_NAME",nameText);
                startActivity(intent);

            }
        });
    }



}