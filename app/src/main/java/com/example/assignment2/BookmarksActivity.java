package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class BookmarksActivity extends AppCompatActivity {

    private String[] temp;
    private Phrase[] tempList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmarks);

        ListView listView = findViewById(R.id.bookmarks_list);

        PhraseDB database = new PhraseDB(BookmarksActivity.this);

        tempList = database.getBookmarksList();
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

    @Override
    public void onResume() {
        super.onResume();
        ListView listView = findViewById(R.id.bookmarks_list);

        PhraseDB database = new PhraseDB(BookmarksActivity.this);

        tempList = database.getBookmarksList();
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
}