package com.mikonski.UItest.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mikonski.UItest.DetailsActivity;
import com.mikonski.UItest.Models.Places;
import com.mikonski.UItest.R;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder>{
    List<Places> placesList;
    Context context;

    public CustomAdapter(List<Places> placesList, Context context) {
        this.placesList = placesList;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Places places = placesList.get(position);
      holder.imageView.setImageResource(places.getImage());
      holder.imageView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              context.startActivity(new Intent(context, DetailsActivity.class));
          }
      });

    }

    @Override
    public int getItemCount() {
        return placesList.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);

             imageView = itemView.findViewById(R.id.recimage);
        }
    }

}
