package com.mikonski.UItest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.mikonski.UItest.Models.Places;
import com.mikonski.UItest.adapters.CustomAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(" HOME");
        getSupportActionBar().setIcon(R.drawable.ic_action_menu);

        //recyclers
        RecyclerView today = findViewById(R.id.today_rec);
        RecyclerView near= findViewById(R.id.near_rec);


        List<Places> placesList = new ArrayList<Places>();

        Places place1 = new Places();
        place1.setImage(R.drawable.image_1);

        Places place2 = new Places();
        place2.setImage(R.drawable.image_2);

        Places place3 = new Places();
        place3.setImage(R.drawable.image_3);

        placesList.add(place1);
        placesList.add(place2);
        placesList.add(place3);



        CustomAdapter customAdapter = new CustomAdapter(placesList, this);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        today.setAdapter(customAdapter);
        today.setLayoutManager(linearLayoutManager);
        near.setAdapter(customAdapter);
        near.setLayoutManager(linearLayoutManager1);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if(id==R.id.menu_logout){
            //display login page
            Intent login = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(login);
            return true;
        }
        if(id==R.id.menu_map){
            //display map page
            startActivity(new Intent(MainActivity.this, MapActivity.class));
           return true;
        }
        if(id==R.id.menu_order){
            startActivity(new Intent(MainActivity.this, OrderDetail.class));
            return true;
        }
        return super.onOptionsItemSelected(item);


    }
}