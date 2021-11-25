package com.example.android.practiceset2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int day1 = 15;
        int day2 = 22;
        int day3 = 18;
        display((day1 + day2 + day3 )/ 3);

    }

    private void display(int solution) {
        TextView displayTextView=findViewById(R.id.display_text_view);
        displayTextView.setText(""+solution);
    }
}