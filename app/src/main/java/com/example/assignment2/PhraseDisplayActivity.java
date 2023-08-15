package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PhraseDisplayActivity extends AppCompatActivity {

    private String category, audioFileName;
    private int listIndex, itemIndex;
    private String[] temp;
    private TextView categoryTextView, englishTextView, koreanTextView, romanizationTextView;
    private MediaPlayer player;

    PhraseDB database = new PhraseDB(PhraseDisplayActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrase_display);
        englishTextView = findViewById(R.id.englishTextView);
        categoryTextView = findViewById(R.id.categoryTextView);
        koreanTextView = findViewById(R.id.koreanTextView);
        romanizationTextView = findViewById(R.id.romanizationTextView);


        Intent intent = getIntent();
        if (intent != null) {
            category = intent.getStringExtra("Category");
            listIndex = Integer.valueOf(intent.getStringExtra("listIndex"));
            itemIndex = Integer.valueOf(intent.getStringExtra("ItemIndex"));
            audioFileName = database.database[listIndex][itemIndex].audioFileName;


            categoryTextView.setText("Category - " + category);
            englishTextView.setText("English:\n" + database.database[listIndex][itemIndex].englishText);
            koreanTextView.setText("Korean:\n" + database.database[listIndex][itemIndex].koreanText);
            romanizationTextView.setText("Romanization:\n" + database.database[listIndex][itemIndex].romanization);
        }


        Button playButton = findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                player = MediaPlayer.create(PhraseDisplayActivity.this, getResources().getIdentifier(audioFileName, "raw", getPackageName()));
                player.start();
            }
        });

        SharedPreferences prefs = PhraseDisplayActivity.this.getSharedPreferences("Database", 0);
        final Button addBookmark = findViewById(R.id.addBookmark);
        if (prefs.getBoolean("DateBase_" + String.valueOf(listIndex) + "_" + String.valueOf(itemIndex), false)) {
            addBookmark.setText("Remove Bookmark");
        } else {
            addBookmark.setText("add a bookmark");
        }

        addBookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = PhraseDisplayActivity.this.getSharedPreferences("Database", 0);
                if (prefs.getBoolean("DateBase_" + String.valueOf(listIndex) + "_" + String.valueOf(itemIndex), false)) {
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putBoolean("DateBase_" + String.valueOf(listIndex) + "_" + String.valueOf(itemIndex), false);
                    editor.commit();
                    Toast.makeText(PhraseDisplayActivity.this, "removed", Toast.LENGTH_SHORT).show();
                    addBookmark.setText("add a bookmark");
                } else {
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putBoolean("DateBase_" + String.valueOf(listIndex) + "_" + String.valueOf(itemIndex), true);
                    editor.commit();
                    Toast.makeText(PhraseDisplayActivity.this, "added", Toast.LENGTH_SHORT).show();
                    addBookmark.setText("Remove Bookmark");
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopPlaying();
    }

    private void stopPlaying() {
        if (player != null) {
            player.stop();
            player.release();
            player = null;
        }
    }
}
