package com.example.mp3_player;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class SongActivity extends AppCompatActivity {
    static MediaPlayer song;
    static int actualSongIndex = 0;
    static HashMap<Integer, Integer> songs = new HashMap<>();
    MediaPlayer vectorSongs[]=new MediaPlayer[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_song);
        TextView textViewTitle = findViewById(R.id.textViewTitle);
        String[] defaultSongsTitles = getResources().getStringArray(R.array.defaultSongsArray);

        vectorSongs[0] = MediaPlayer.create(this, R.raw.cyberpunk);
        vectorSongs[1] = MediaPlayer.create(this, R.raw.earth);
        vectorSongs[2] = MediaPlayer.create(this, R.raw.make_me_move);
        vectorSongs[3] = MediaPlayer.create(this, R.raw.stockholm_lights);
        vectorSongs[4] = MediaPlayer.create(this, R.raw.supersonic);
        vectorSongs[5] = MediaPlayer.create(this, R.raw.we_are_one);

        Intent caller = getIntent();
        actualSongIndex = caller.getIntExtra("title",0);
        textViewTitle.setText(defaultSongsTitles[actualSongIndex]);
        song = vectorSongs[actualSongIndex];
        song.start();
    }
    public void playPause(View view){
        if(song.isPlaying()){
            song.pause();
            view.setBackgroundResource(R.drawable.play);
        }else{
            song.start();
            view.setBackgroundResource(R.drawable.pause);
        }
    }
    public void previousSong(View view){
        try{
            TextView textViewTitle = findViewById(R.id.textViewTitle);
            Button buttonPlayPause = findViewById(R.id.buttonPlay);
            String[] defaultSongsTitles = getResources().getStringArray(R.array.defaultSongsArray);
            song.stop();
            song.prepare();
            if((actualSongIndex-1)<0){
                buttonPlayPause.setBackgroundResource(R.drawable.pause);
                actualSongIndex = 5;
                song = vectorSongs[5];
                textViewTitle.setText(defaultSongsTitles[5]);
                song.start();
            }else{
                buttonPlayPause.setBackgroundResource(R.drawable.pause);
                actualSongIndex --;
                song = vectorSongs[actualSongIndex];
                textViewTitle.setText(defaultSongsTitles[actualSongIndex]);
                song.start();
            }
        }catch (Exception e){
            Toast.makeText(this, R.string.errorText, Toast.LENGTH_SHORT).show();
            finish();
        }

    }
    public void nextSong(View view){
        try {
            Button buttonPlayPause = findViewById(R.id.buttonPlay);
            TextView textViewTitle = findViewById(R.id.textViewTitle);
            String[] defaultSongsTitles = getResources().getStringArray(R.array.defaultSongsArray);
            song.stop();
            song.prepare();
            if ((actualSongIndex+1)>5){
                actualSongIndex = 0;
                song = vectorSongs[0];
                buttonPlayPause.setBackgroundResource(R.drawable.pause);
                textViewTitle.setText(defaultSongsTitles[0]);
                song.start();
            }else{
                actualSongIndex++;
                song = vectorSongs[actualSongIndex];
                buttonPlayPause.setBackgroundResource(R.drawable.pause);
                textViewTitle.setText(defaultSongsTitles[actualSongIndex]);
                song.start();
            }
        } catch (Exception exception){
            Toast.makeText(this, R.string.errorText, Toast.LENGTH_SHORT).show();
            finish();
        }

    }
    public void loop(View view){
        Switch switchLoop = findViewById(R.id.switchLoop);
        switchLoop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                song.setLooping(isChecked);
            }
        });
    }
    @Override
    public void onPause ()
    {
        if (song != null) {
            song.pause();
            song.stop();
        }
        super.onPause();
    }
    @Override
    public void onBackPressed () {
        if (song != null) {
            song.stop();
        }
        super.onBackPressed();
    }

}
