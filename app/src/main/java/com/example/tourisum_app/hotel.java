package com.example.tourisum_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tourisum_app.adapter.hotelAdapter;

import com.example.tourisum_app.model.hotelData;


import java.util.ArrayList;
import java.util.List;

public class hotel extends AppCompatActivity {

    RecyclerView recyclerView;
    hotelAdapter hotel_adapter;
    List<hotelData>  hotelDataList;

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hotel);

        //back to dashboard btn
        imageView=findViewById(R.id.backToDashboard);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(hotel.this,Dashboard.class);
                startActivity(intent);
            }
        });

        //adding hotel details to recyclerView
        hotelDataList=new ArrayList<>();
        hotelDataList.add(new hotelData("Radisson Blu Plaza.","Only 1.9 km from Mysore Palace,Mysore.","11,000",R.drawable.img_11,5f));
        hotelDataList.add(new hotelData("Royal Orchid Brindavan Garden.","Only 19.8 km from city center,Mysore.","10,000",R.drawable.img_12,4.5f));
        hotelDataList.add(new hotelData("Vijayshree Resort.","Only 7.8 km Center Bus Stand,Hampi..","6,999",R.drawable.img_13,4.0f));
        hotelDataList.add(new hotelData("Bhramari Nest.","Only 2.7 km Center Bus Stand,Kukke.","2,999",R.drawable.img_14,4.0f));
        hotelDataList.add(new hotelData("Spoorti Resort.","Only 4.5 km City Center ,Bijapur.","3,999",R.drawable.img_16,4.5f));
        hotelDataList.add(new hotelData("Hotel Clarks.","Only 3.1 km City Center,Agra.","8,999",R.drawable.img_15,5.0f));
        setRecentRecycler(hotelDataList);

    }

    private void setRecentRecycler(List<hotelData> hotelDataList) {

        recyclerView = findViewById(R.id.liked_recycler2);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
       hotel_adapter = new hotelAdapter(this, hotelDataList);
        recyclerView.setAdapter(hotel_adapter);
    }
}