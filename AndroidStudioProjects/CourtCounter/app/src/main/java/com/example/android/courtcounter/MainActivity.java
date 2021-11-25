package com.example.android.courtcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int Ascore=0;int Bscore=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pointA3(View view) {
        Ascore=Ascore+3;
        displayForTeamA(Ascore);
    }
    public void pointA2(View view) {
        Ascore=Ascore+2;
        displayForTeamA(Ascore);
    }
    public void freeThrowA(View view) {
        Ascore=Ascore+1;
        displayForTeamA(Ascore);
    }

    private void displayForTeamA(int ascore) {
        TextView scoreTeamA=findViewById(R.id.score_team_A);
        scoreTeamA.setText(String.valueOf(ascore));
    }
    private void displayForTeamB(int bscore) {
        TextView scoreTeamB=findViewById(R.id.score_team_B);
        scoreTeamB.setText(String.valueOf(bscore));
    }
    public void pointB3(View view) {
        Bscore=Bscore+3;
        displayForTeamB(Bscore);
    }
    public void pointB2(View view) {
        Bscore=Bscore+2;
        displayForTeamB(Bscore);
    }public void freeThrowB(View view) {
        Bscore=Bscore+1;
        displayForTeamB(Bscore);
    }
     public void resetScore(View view) {
        Ascore=0;
        Bscore=0;
        displayForTeamA(Ascore);
        displayForTeamB(Bscore);
    }
}