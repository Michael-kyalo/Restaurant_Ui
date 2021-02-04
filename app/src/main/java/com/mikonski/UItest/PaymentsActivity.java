package com.mikonski.UItest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.mikonski.UItest.Models.Card;
import com.mikonski.UItest.adapters.CardAdapter;

import java.util.ArrayList;
import java.util.List;

public class PaymentsActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payments);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(" ORDER DETAIL");
        getSupportActionBar().setIcon(R.drawable.ic_action_back);

        RecyclerView recyclerView = findViewById(R.id.card_rec);

        List<Card> cardList = new ArrayList<Card>();

        Card card = new Card();
        card.setTitle("Debit Card");
        card.setLogo(R.drawable.debitcard_logo);

        Card card1 = new Card();
        card1.setTitle("Credit Card");
        card1.setLogo(R.drawable.creditcard_logo);

        Card card2 = new Card();
        card2.setTitle("PayPal");
        card2.setLogo(R.drawable.paypal_logo);

        Card card3 = new Card();
        card3.setTitle("M-Pesa");
        card3.setLogo(R.drawable.mpesa_logo);

        Card card4 = new Card();
        card4.setTitle("PayCash");
        card4.setLogo(R.drawable.paycash_logo);

        cardList.add(card);
        cardList.add(card1);
        cardList.add(card2);
        cardList.add(card3);
        cardList.add(card4);

        CardAdapter cardAdapter = new CardAdapter(cardList,this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(cardAdapter);



    }
}