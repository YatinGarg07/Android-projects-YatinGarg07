package com.example.mediaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private Button play;
    private Button song2;
    private Button song3;
    private SeekBar seekBar;
    private MediaPlayer mediaPlayer0;
    private static int i;
    private String data[]={"R.raw.shinjekinokyojin","R.id.requiem","R.raw.yuugurenotori"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = findViewById(R.id.play);
        song2 = findViewById(R.id.song2);
        song3=findViewById(R.id.song3);
        seekBar = findViewById(R.id.seekBar);

//        Media player using local source
        mediaPlayer0 = MediaPlayer.create(this,R.raw.shinjekinokyojin);

//
//        mediaPlayer.prepareAsync();

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser)mediaPlayer0.seekTo(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer0.isPlaying()&&i==1) {
                    mediaPlayer0.pause();
                    play.setText("Start1");
                } else {
                  mediaPlayer0= stopPlaying(mediaPlayer0);
                   mediaPlayer0=MediaPlayer.create(MainActivity.this,R.raw.shinjekinokyojin);
                    seekBar.setMax(mediaPlayer0.getDuration());
                    seekBar.setProgress(0);
                    mediaPlayer0.start();i=1;
                    play.setText("Pause1");
                    song2.setText("Start2");
                    song3.setText("Start3");
                }
            }
        });
        song2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer0.isPlaying()&&i==2) {
                    mediaPlayer0.pause();
                    song2.setText("Start2");
                } else {
                   mediaPlayer0= stopPlaying(mediaPlayer0);
                    mediaPlayer0=MediaPlayer.create(MainActivity.this,R.raw.yuugurenotori);
                    seekBar.setMax(mediaPlayer0.getDuration());
                    seekBar.setProgress(0);
                   mediaPlayer0.start();i=2;
                    song2.setText("Pause2");
                    play.setText("Start1");
                    song3.setText("Start3");
                }
            }
        });
        song3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer0.isPlaying()&&i==3) {
                    mediaPlayer0.pause();
                    song3.setText("Start3");

                } else {
                   mediaPlayer0= stopPlaying(mediaPlayer0);
                    mediaPlayer0=MediaPlayer.create(MainActivity.this,R.raw.requiem);
                    seekBar.setMax(mediaPlayer0.getDuration());
                    seekBar.setProgress(0);
                    mediaPlayer0.start();i=3;
                    play.setText("Start1");
                    song2.setText("Start2");
                    song3.setText("Pause3");
                }
            }
        });


    }
    public MediaPlayer stopPlaying(MediaPlayer mp){
        if(mp!=null)
            mp.stop();
        mp.release();

        return mp;
    }
}