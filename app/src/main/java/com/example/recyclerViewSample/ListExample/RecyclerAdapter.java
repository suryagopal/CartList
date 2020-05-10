package com.example.recyclerViewSample.ListExample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.recyclerViewSample.R;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.CardViewHolder> {

    private final ArrayList<CardData> data;

    public RecyclerAdapter(ArrayList<CardData> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.card_item, parent, false);
        return new CardViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        holder.updateView(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class CardViewHolder extends RecyclerView.ViewHolder {

        CardViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        void updateView(CardData data) {
            ((TextView) itemView.findViewById(R.id.text1)).setText(data.text1);
            ((TextView) itemView.findViewById(R.id.text2)).setText(data.text2);
            itemView.findViewById(R.id.show_button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(), "Clicked", Toast.LENGTH_LONG).show();
                }
            });
        }
    }

}
