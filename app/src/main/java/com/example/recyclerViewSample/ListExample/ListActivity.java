package com.example.recyclerViewSample.ListExample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;


import com.example.recyclerViewSample.R;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        ((RecyclerView) findViewById(R.id.recyclerView)).setLayoutManager(linearLayoutManager);
        RecyclerAdapter adapter = new RecyclerAdapter(generateData());
        ((RecyclerView) findViewById(R.id.recyclerView)).setAdapter(adapter);
    }

    ArrayList<CardData> generateData() {
        ArrayList<CardData> data = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            data.add(new CardData("Text1" + i, "Text2" + i));
        }

        return data;
    }
}
