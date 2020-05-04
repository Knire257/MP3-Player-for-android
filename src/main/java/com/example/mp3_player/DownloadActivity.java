package com.example.mp3_player;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class DownloadActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_acvtivity);
        ListView listSongsAvailableForDownload = findViewById(R.id.listViewDownloadSongs);
        final String[] urlSongs = getResources().getStringArray(R.array.urlSongsForDownload);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.SongsForDownload,
                android.R.layout.simple_list_item_1);
        listSongsAvailableForDownload.setAdapter(adapter);
        listSongsAvailableForDownload.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String stringUrl = urlSongs[position];
                Uri uriUrl = Uri.parse(stringUrl);
                try{
                    Intent web = new Intent(Intent.ACTION_VIEW, uriUrl);
                    startActivity(web);
                }catch (Exception error){
                    Toast.makeText(parent.getContext(),R.string.errorOpeningBrowser,Toast.LENGTH_LONG).show();
                }

            }
        });
    }
    public void launchCreditsActivity(View view){
        Intent goToCredits = new Intent();
        goToCredits.setClass(this, CreditsActivity.class);
        startActivity(goToCredits);
    }
}
