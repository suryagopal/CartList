package com.example.recyclerViewSample.mvvm;

import androidx.lifecycle.ViewModel;


import com.example.recyclerViewSample.ListExample.CardData;
import com.example.recyclerViewSample.ListExample.RecyclerAdapter;

import java.util.ArrayList;

public class ListActivityViewModel extends ViewModel {

    private RecyclerAdapter adapter;

    void init(){
        adapter = new RecyclerAdapter(generateData());
    }

    public RecyclerAdapter getAdapter() {
        return adapter;
    }

    private ArrayList<CardData> generateData() {
        ArrayList<CardData> data = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            data.add(new CardData("Tik" + i, "Tok" + i));
        }

        return data;
    }
}
