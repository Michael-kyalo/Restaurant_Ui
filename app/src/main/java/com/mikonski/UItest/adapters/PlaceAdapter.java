package com.mikonski.UItest.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mikonski.UItest.Models.Places;
import com.mikonski.UItest.R;

import java.util.List;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.PlaceViewHolder> {
    Context context;
    List<Places> placesList;

    public PlaceAdapter(Context context, List<Places> placesList) {
        this.context = context;
        this.placesList = placesList;
    }

    @NonNull
    @Override
    public PlaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item,parent,false);
        return new PlaceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceViewHolder holder, int position) {
        Places places = placesList.get(position);

        if(position==3){
            holder.linearLayout.setVisibility(View.VISIBLE);
            holder.textView.setText(String.valueOf(placesList.size()-position) + "+");
        }
        holder.imageView.setImageResource(places.getImage());

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class PlaceViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        LinearLayout linearLayout;
        ImageView imageView;
        public PlaceViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.place_image);
            linearLayout = itemView.findViewById(R.id.blue);
            textView = itemView.findViewById(R.id.rem);
        }
    }
}
