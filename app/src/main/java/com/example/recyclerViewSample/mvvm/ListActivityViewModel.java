package com.example.recyclerViewSample.mvvm;

import android.content.Context;

import androidx.lifecycle.ViewModel;

import com.example.recyclerViewSample.ListExample.CardData;
import com.example.recyclerViewSample.ListExample.RecyclerAdapter;

import java.util.ArrayList;

public class ListActivityViewModel extends ViewModel {

    RecyclerAdapter adapter;

    public void init(Context context) {
        adapter = new RecyclerAdapter(generateData(), context);
    }

    public RecyclerAdapter getAdapter() {
        return adapter;
    }

    ArrayList<CardData> generateData() {
        ArrayList<CardData> data = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                data.add(new CardData(i, "Tik" + i, "Tok" + i, false));
            } else {
                data.add(new CardData(i, "Tik" + i, "Tok" + i, true));
            }
        }

        return data;
    }
}
