package com.mikonski.UItest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.mikonski.UItest.Models.Food;
import com.mikonski.UItest.adapters.OrderAdapter;

import java.util.ArrayList;
import java.util.List;

public class OrderDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(" ORDER DETAIL");
        getSupportActionBar().setIcon(R.drawable.ic_action_back);

        //Recyclerview
        RecyclerView recyclerView = findViewById(R.id.orderRec);

        List<Food> foods = new ArrayList<Food>();

        Food food = new Food();
        food.setName("Chilli Chicken");
        food.setImage(R.drawable.image_1);

        Food food1 = new Food();
        food1.setName("Chowmein");
        food1.setImage(R.drawable.image_2);

        Food food2 = new Food();
        food2.setName("Fried Rice");
        food2.setImage(R.drawable.image_3);

        foods.add(food);
        foods.add(food1);
        foods.add(food2);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        OrderAdapter orderAdapter = new OrderAdapter(foods,this);
        recyclerView.setAdapter(orderAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);

        LinearLayout next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OrderDetail.this, PaymentsActivity.class));
            }
        });

    }
}