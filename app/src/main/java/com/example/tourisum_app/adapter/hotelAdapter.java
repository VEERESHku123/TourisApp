package com.example.tourisum_app.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tourisum_app.R;
import com.example.tourisum_app.detailActivity;
import com.example.tourisum_app.model.hotelData;

import java.util.List;

public class hotelAdapter extends RecyclerView.Adapter<hotelAdapter.hotels> {

    Context context;
    List<hotelData> hotelDataList;

    public hotelAdapter(Context context,List<hotelData> hotelDataList){
        this.context=context;
        this.hotelDataList=hotelDataList;
    }

    @NonNull
    @Override
    public hotelAdapter.hotels onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.hotel_col_item, parent, false);
        // here we create a recyclerview row item layout file
        return new hotels(view);
    }

    @Override
    public void onBindViewHolder(@NonNull hotels holder, int position) {
        holder.hotelName.setText(hotelDataList.get(position).getHotelName());
        holder.hotelPlace.setText(hotelDataList.get(position).getHotelPlace());
        holder.price.setText(hotelDataList.get(position).getPrice());
        holder.hotelImage.setImageResource(hotelDataList.get(position).getImageUrl());
        holder.ratingBar.setRating(hotelDataList.get(position).getRating());

        holder.ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                hotelDataList.iterator();
                // Save the updated rating to the database or perform any action as needed
            }
        });



    }

    @Override
    public int getItemCount() {
        return hotelDataList.size();
    }

    public static final class hotels extends RecyclerView.ViewHolder{
        ImageView hotelImage;
        TextView hotelName, hotelPlace, price;
        RatingBar ratingBar;


        public hotels(@NonNull View itemView) {
            super(itemView);

           hotelImage = itemView.findViewById(R.id.hotel_image);
            hotelName= itemView.findViewById(R.id.hotel_name);
            hotelPlace = itemView.findViewById(R.id.hotel_place);
            price = itemView.findViewById(R.id.price);
            ratingBar=itemView.findViewById(R.id.rating);

        }
    }
}
