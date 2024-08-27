package com.example.tourisum_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class detailActivity extends AppCompatActivity {

    ImageView Image;
    TextView placeName,price,about;
    Button btn;
    RatingBar ratingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        Image=findViewById(R.id.imageView);
        placeName=findViewById(R.id.placeName);
        price=findViewById(R.id.price);
        about=findViewById(R.id.information);
        ratingBar=findViewById(R.id.rating);

        String Name=getIntent().getStringExtra("PLACENAME");
        String Price=getIntent().getStringExtra("PRICE");
        String About=getIntent().getStringExtra("ABOUT");
        int i=getIntent().getIntExtra("IMAGE",0);
        float rate=getIntent().getFloatExtra("RATE",0.0f);

        placeName.setText(Name);
        price.setText(Price);
        Image.setImageResource(i);
        about.setText(About);
        ratingBar.setRating(rate);


        btn=findViewById(R.id.bookPlan);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(detailActivity.this,BookPlan.class);
                startActivity(intent);
            }
        });



    }
}