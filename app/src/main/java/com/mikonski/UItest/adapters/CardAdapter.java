package com.mikonski.UItest.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.mikonski.UItest.Models.Card;
import com.mikonski.UItest.R;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {
    List<Card> cardList;
    Context context;

    public CardAdapter(List<Card> cardList, Context context) {
        this.cardList = cardList;
        this.context = context;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item,parent,false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        Card card = cardList.get(position);

        holder.logo.setImageResource(card.getLogo());
        holder.title.setText(card.getTitle());

        if(position==0){
            holder.card.setBackgroundResource(R.drawable.card_item_pink_outline_background);
        }


    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder{
         ImageView logo;
         TextView title;
         ConstraintLayout card;
        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            logo = itemView.findViewById(R.id.card_logo);
            title = itemView.findViewById(R.id.card_title);
            card= itemView.findViewById(R.id.single_item);
        }
    }
}
