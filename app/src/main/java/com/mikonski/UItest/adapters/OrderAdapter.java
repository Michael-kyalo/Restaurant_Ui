package com.mikonski.UItest.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mikonski.UItest.Models.Food;
import com.mikonski.UItest.R;

import java.util.List;

public class OrderAdapter  extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder>{
    List<Food> foodList;
    Context context;

    public OrderAdapter(List<Food> foodList, Context context) {
        this.foodList = foodList;
        this.context = context;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_item,parent,false);
        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        Food food = foodList.get(position);
        holder.textView.setText(food.getName());
        holder.imageView.setImageResource(food.getImage());

    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public class OrderViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.title_text);
            imageView = itemView.findViewById(R.id.food_image);
        }
    }
}
