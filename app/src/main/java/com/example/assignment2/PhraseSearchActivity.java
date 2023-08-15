package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class PhraseSearchActivity extends AppCompatActivity {

    private String category, target;
    private String[] temp;
    private Phrase[] tempList;
    private ListView listView;
    private EditText englishEditText;
    private EditText koreanEditText;
    private Button englishButton;
    private Button koreanButton;
    private PhraseDB database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrase_search);


        listView = findViewById(R.id.search_list);
        englishEditText = findViewById(R.id.englishEditText);
        koreanEditText = findViewById(R.id.koreanEditText);
        englishButton = findViewById(R.id.englishButton);
        koreanButton = findViewById(R.id.koreanButton);
        database = new PhraseDB(PhraseSearchActivity.this);

        addButtonsListener();
        category = "Searching";
    }

    private void addButtonsListener() {
        englishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                target = String.valueOf(englishEditText.getText());
                searchByEnglish();
            }
        });
        koreanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                target = String.valueOf(koreanEditText.getText());
                searchByKorean();
            }
        });
    }

    private void searchByEnglish() {
        tempList = database.getSearchByEnglishList(target);
        temp = new String[tempList.length];
        for (int i = 0; i < tempList.length; i++)
            temp[i] = (i + 1) + ". " + tempList[i].englishText + " - " + getResources().getStringArray(R.array.category)[tempList[i].listIndex];

        final ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, temp);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(getApplicationContext(), PhraseDisplayActivity.class);
                intent.putExtra("Category", getResources().getStringArray(R.array.category)[tempList[position].listIndex]);
                intent.putExtra("listIndex", String.valueOf(tempList[position].listIndex));
                intent.putExtra("ItemIndex", String.valueOf(tempList[position].itemIndex));
                startActivity(intent);
            }
        });
    }

    private void searchByKorean() {
        tempList = database.getSearchByKoreanList(target);
        temp = new String[tempList.length];
        for (int i = 0; i < tempList.length; i++)
            temp[i] = (i + 1) + ". " + tempList[i].koreanText + " - " + getResources().getStringArray(R.array.category)[tempList[i].listIndex];

        final ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, temp);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(getApplicationContext(), PhraseDisplayActivity.class);
                intent.putExtra("Category", getResources().getStringArray(R.array.category)[tempList[position].listIndex]);
                intent.putExtra("listIndex", String.valueOf(tempList[position].listIndex));
                intent.putExtra("ItemIndex", String.valueOf(tempList[position].itemIndex));
                startActivity(intent);
            }
        });
    }
}