package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class PhrasesListActivity extends AppCompatActivity {

    private String category;
    private String[] temp;
    private TextView categoryTitle;
    private Phrase[] tempList;
    private int listIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases_list);

        ListView listView = findViewById(R.id.content_list);
        categoryTitle = findViewById(R.id.categoryTitle);

        PhraseDB database = new PhraseDB(PhrasesListActivity.this);

        Intent intent = getIntent();
        if (intent != null) {
            listIndex = Integer.valueOf(intent.getStringExtra("ItemIndex"));
            category = getResources().getStringArray(R.array.category)[listIndex];
            categoryTitle.setText(category);

            tempList = database.getList(listIndex);
            temp = new String[tempList.length];
            for (int i = 0; i < tempList.length; i++)
                temp[i] = tempList[i].englishText;

            final ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, temp);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    Intent intent = new Intent(getApplicationContext(), PhraseDisplayActivity.class);
                    intent.putExtra("Category", category);
                    intent.putExtra("listIndex", String.valueOf(tempList[position].listIndex));
                    intent.putExtra("ItemIndex", String.valueOf(tempList[position].itemIndex));
                    startActivity(intent);
                }
            });
        }
    }
}
