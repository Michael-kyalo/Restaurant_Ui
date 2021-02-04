package com.mikonski.UItest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.material.tabs.TabLayout;
import com.mikonski.UItest.Models.Places;
import com.mikonski.UItest.adapters.CustomAdapter;
import com.mikonski.UItest.adapters.FragmentAdapter;
import com.mikonski.UItest.adapters.PlaceAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DetailsActivity extends AppCompatActivity implements OnMapReadyCallback {
    ViewPager viewPager;
    TabLayout tabLayout;
    ArrayList<Fragment> fragments;
    Toolbar toolbar;
    MapView mapView;
    private static final String MAPVIEW_BUNDLE_KEY = "MapViewBundleKey";
    private static final String TAG = "DetailsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        toolbar =  findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setIcon(R.drawable.ic_action_back);
        getSupportActionBar().setTitle(" ");


        viewPager = (ViewPager) findViewById(R.id.pager);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        fragments =new ArrayList<>();

        fragments.add(new homeFragment());
        fragments.add(new homeFragment());
        fragments.add(new homeFragment());
        fragments.add(new homeFragment());



        FragmentAdapter pagerAdapter = new FragmentAdapter(getSupportFragmentManager(), getApplicationContext(), fragments);
        viewPager.setAdapter(pagerAdapter);

        tabLayout.setupWithViewPager(viewPager);

        Objects.requireNonNull(tabLayout.getTabAt(0)).setText("Recommended");
        Objects.requireNonNull(tabLayout.getTabAt(1)).setText("Mains");
        Objects.requireNonNull(tabLayout.getTabAt(2)).setText("Beverages");
        Objects.requireNonNull(tabLayout.getTabAt(3)).setText("Desserts");

        //map
        mapView = findViewById(R.id.mapView2);
        // *** IMPORTANT ***
        // MapView requires that the Bundle you pass contain _ONLY_ MapView SDK
        // objects or sub-Bundles.
        Bundle mapViewBundle = null;
        if (savedInstanceState != null) {
            mapViewBundle = savedInstanceState.getBundle(MAPVIEW_BUNDLE_KEY);
        }
        mapView.onCreate(mapViewBundle);
        mapView.getMapAsync(this::onMapReady);

        RecyclerView near= findViewById(R.id.rec);

        List<Places> placesList = new ArrayList<Places>();

        Places place1 = new Places();
        place1.setImage(R.drawable.image_1);

        Places place2 = new Places();
        place2.setImage(R.drawable.image_2);

        Places place3 = new Places();
        place3.setImage(R.drawable.image_3);
        Places place4 = new Places();
        place1.setImage(R.drawable.image_1);

        Places place5 = new Places();
        place2.setImage(R.drawable.image_2);

        Places place6 = new Places();
        place3.setImage(R.drawable.image_3);

        placesList.add(place1);
        placesList.add(place2);
        placesList.add(place3);
        placesList.add(place4);
        placesList.add(place5);
        placesList.add(place6);

        PlaceAdapter customAdapter = new PlaceAdapter(this,placesList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        near.setLayoutManager(linearLayoutManager);
        near.setAdapter(customAdapter);


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        try {
            boolean success = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            this, R.raw.style_json));

            if (!success) {
                Log.e(TAG, "Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Can't find style. Error: ", e);
        }


        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-1.288811,36.823219),15.0f));

    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Bundle mapViewBundle = outState.getBundle(MAPVIEW_BUNDLE_KEY);
        if (mapViewBundle == null) {
            mapViewBundle = new Bundle();
            outState.putBundle(MAPVIEW_BUNDLE_KEY, mapViewBundle);
        }

        mapView.onSaveInstanceState(mapViewBundle);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }
}