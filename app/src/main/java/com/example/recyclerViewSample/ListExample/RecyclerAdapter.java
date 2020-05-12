package com.example.recyclerViewSample.ListExample;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerViewSample.R;
import com.example.recyclerViewSample.mvvm.DialogueCallback;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.CardViewHolder> {

    final ArrayList<CardData> data;
    private Context context;

    public RecyclerAdapter(ArrayList<CardData> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.card_item, parent, false);
        CardViewHolder viewHolder = new CardViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        holder.updateView(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class CardViewHolder extends RecyclerView.ViewHolder{

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void updateView(CardData data){
            ((TextView)itemView.findViewById(R.id.text1)).setText(data.text1);
            ((TextView)itemView.findViewById(R.id.text2)).setText(data.text2);

            itemView.findViewById(R.id.edit).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialogue(data, new DialogueCallback() {
                        @Override
                        public void add(int id, String value) {
                            for(int i=0;i<RecyclerAdapter.this.data.size();i++){
                                if(RecyclerAdapter.this.data.get(i).id == id){
                                    RecyclerAdapter.this.data.get(i).text1 = value;
                                    notifyItemChanged(i);
                                }
                            }
                        }
                    });
                }
            });

            itemView.findViewById(R.id.remove).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for(int i=0;i<RecyclerAdapter.this.data.size();i++){
                        if(data.id == RecyclerAdapter.this.data.get(i).id) {
                            RecyclerAdapter.this.data.remove(i);
                            notifyItemRemoved(i);
                            break;
                        }
                    }
                }
            });


        }

        public void showDialogue(CardData data, final DialogueCallback dialogueCallback){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            android.app.AlertDialog.Builder alertBuilder = new android.app.AlertDialog.Builder(context);
            View dialogView = inflater.inflate(R.layout.dialogue, null);
            alertBuilder.setView(dialogView);
            alertBuilder.setCancelable(true);

            Button btnAdd = dialogView.findViewById(R.id.btnAdd);
            EditText tik = dialogView.findViewById(R.id.edit_text);
            tik.setText(data.text1);

            final android.app.AlertDialog alert = alertBuilder.create();

            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialogueCallback.add(data.id, tik.getText().toString());
                    alert.dismiss();

                }
            });
            alert.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            alert.show();

        }

    }

}
