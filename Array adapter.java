package com.example.arrayadapterexample;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        // Data to be displayed in ListView
        String[] fruits = {"Apple", "Banana", "Orange", "Mango", "Grapes", "Pineapple", "Strawberry", "Blueberry"};

        // Create an ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,                        // Context (current activity)
                android.R.layout.simple_list_item_1, // Layout resource (default list item)
                fruits                       // Data to display
        );

        // Set the adapter to the ListView
        listView.setAdapter(adapter);
    }
}
