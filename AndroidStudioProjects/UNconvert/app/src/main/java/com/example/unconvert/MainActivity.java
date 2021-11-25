package com.example.unconvert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.icu.text.DisplayContext.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {

    private Button clicked;
    private EditText numInText;
    private TextView answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clicked = findViewById(R.id.converted);
        numInText=findViewById(R.id.weight_in_KG);
        answer = findViewById(R.id.WeightInPound) ;
        clicked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s =numInText.getText().toString() ;
                int num=0;
                if(!s.equals("")) {num = Integer.parseInt(s);}
                double pound = 2.204 * num ;
                answer.setText("The corresponding value in pounds is "+ pound);



            }
        });


    }
}