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
import com.example.tourisum_app.model.likedData;
import com.example.tourisum_app.model.placeDetails;

import java.util.List;

public class likedAdapter_seeAll extends RecyclerView.Adapter<likedAdapter_seeAll.likedPlace> {

    Context context;
    List<likedData> likedDataList;
    List<placeDetails> placeDetailsList;

    public likedAdapter_seeAll(Context context, List<likedData> list, List<placeDetails> placeDetailsList) {
        this.context = context;
        this.likedDataList =list;
        this.placeDetailsList=placeDetailsList;
    }

    public void setFilteredList(List<likedData> likedDataList){
        this.likedDataList=likedDataList;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public likedPlace onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.liked_col_item, parent, false);
        // here we create a recyclerview row item layout file
       return new likedPlace(view);

    }

    @Override
    public void onBindViewHolder(@NonNull likedPlace holder, int position) {

        holder.countryName.setText(likedDataList.get(position).getCountryName());
        holder.placeName.setText(likedDataList.get(position).getPlaceName());
        holder.price.setText(likedDataList.get(position).getPrice());
        holder.placeImage.setImageResource(likedDataList.get(position).getImageUrl());
        holder.ratingBar.setRating(placeDetailsList.get(position).getRating());

        holder.ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                placeDetailsList.iterator();
                // Save the updated rating to the database or perform any action as needed
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(context, detailActivity.class);
                i.putExtra("PLACENAME",placeDetailsList.get(holder.getAdapterPosition()).getPlaceName());
                i.putExtra("PRICE",placeDetailsList.get(holder.getAdapterPosition()).getPrice());
                i.putExtra("IMAGE",placeDetailsList.get(holder.getAdapterPosition()).getImageUrl());
                i.putExtra("ABOUT",placeDetailsList.get(holder.getAdapterPosition()).getAbout());
                i.putExtra("RATE",placeDetailsList.get(holder.getAdapterPosition()).getRating());
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });

    }


    @Override
    public int getItemCount() {
        return likedDataList.size();
    }

    public static final class likedPlace extends RecyclerView.ViewHolder{
        ImageView placeImage;
        TextView placeName, countryName, price;
        RatingBar ratingBar;


        public likedPlace(@NonNull View itemView) {
            super(itemView);

            placeImage = itemView.findViewById(R.id.place_image);
            placeName = itemView.findViewById(R.id.place_name);
            countryName = itemView.findViewById(R.id.country_name);
            price = itemView.findViewById(R.id.price);
            ratingBar=itemView.findViewById(R.id.rating);

        }
    }
}
