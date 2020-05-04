package com.example.mp3_player;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CreditsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
        TextView textViewCredits = findViewById(R.id.textViewCreditsBody);
        textViewCredits.setMovementMethod(new ScrollingMovementMethod());
        textViewCredits.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
