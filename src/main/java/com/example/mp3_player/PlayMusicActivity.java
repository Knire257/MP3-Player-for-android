package com.example.mp3_player;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class PlayMusicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);
        ListView listViewSongs = findViewById(R.id.listViewSongs);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.defaultSongsArray,
                android.R.layout.simple_list_item_1);
        listViewSongs.setAdapter(adapter);
        listViewSongs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent goToSong = new Intent();
                goToSong.setClass(parent.getContext(),SongActivity.class);
                goToSong.putExtra("title",position);
                startActivity(goToSong);
            }
        });
    }
    public void launchCreditsActivity(View view){
        Intent goToCredits = new Intent();
        goToCredits.setClass(this, CreditsActivity.class);
        startActivity(goToCredits);
    }

}
