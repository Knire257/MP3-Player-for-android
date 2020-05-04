package com.example.mp3_player;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int contTouches = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void launchPlayMusicActivity(View view){
        Intent goToPlayMusic = new Intent();
        goToPlayMusic.setClass(this,PlayMusicActivity.class);
        startActivity(goToPlayMusic);
    }
    public void launchDownloadActivity(View view){
        Intent goToDownload = new Intent();
        goToDownload.setClass(this,DownloadActivity.class);
        startActivity(goToDownload);
    }
    public void doNotTouch(View view){
        contTouches++;
        if (contTouches==1){
            Toast.makeText(this, R.string.oneTouch, Toast.LENGTH_SHORT).show();
        }else if (contTouches==2) {
            Toast.makeText(this, R.string.twoTouches, Toast.LENGTH_SHORT).show();
        }else if (contTouches==3){
            Toast.makeText(this, R.string.threeTouches, Toast.LENGTH_SHORT).show();
        }else if (contTouches==4){
            Toast.makeText(this, R.string.fourTouches, Toast.LENGTH_SHORT).show();
        }else if (contTouches==5){
            Toast.makeText(this, R.string.fiveTouches, Toast.LENGTH_LONG).show();
            view.setVisibility(View.INVISIBLE);
        }
    }
}
