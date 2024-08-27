package com.example.tourisum_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.tourisum_app.adapter.likedAdapter_seeAll;
import com.example.tourisum_app.model.likedData;
import com.example.tourisum_app.model.placeDetails;
import java.util.ArrayList;
import java.util.List;

public class SeeAll_activity extends AppCompatActivity {

    RecyclerView recyclerView;
    likedAdapter_seeAll likedAdapter;
    List<placeDetails> placeDetailsList;
    List<likedData> likedDataList;

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_all);

        //back btn
        imageView=findViewById(R.id.backToDashboard);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SeeAll_activity.this,Dashboard.class);
                startActivity(intent);
            }
        });

        placeDetailsList=new ArrayList<>();
        String about1="Mysore Palace, also known as Amba Vilas Palace, is a historical palace and a royal residence. It is located in Mysore, Karnataka, India. It used to be the official residence of the Wadiyar dynasty and the seat of the Kingdom of Mysore. The palace is in the centre of Mysore, and faces the Chamundi Hills eastward. Mysore is commonly described as the 'City of the Palaces', and there are seven palaces including this one. However, the Mysore Palace refers specifically to the one within the new fort.";
        String about2="Taj Mahal, mausoleum complex in Agra, western Uttar Pradesh state, northern India. The Taj Mahal was built by the Mughal emperor Shah Jahān (reigned 1628–58) to immortalize his wife Mumtaz Mahal (“Chosen One of the Palace”), who died in childbirth in 1631, having been the emperor’s inseparable companion since their marriage in 1612. India’s most famous and widely recognized building, it is situated in the eastern part of the city on the southern (right) bank of the Yamuna (Jumna) River. Agra Fort (Red Fort), also on the right bank of the Yamuna, is about 1 mile (1.6 km) west of the Taj Mahal.";
        String about3="The Kedarnath Mandir (Temple) that nestles at the foothills of the Himalayas is one of the holiest sites of Hinduism. A shrine dedicated to Lord Shiva, the Destroyer of Evil, the temple is one of the 12 Jyotirlingas across India, one of the Char (4) Dhams (Badrinath, Kedarnath, Yamunotri, Gangotri), and one of the 5 Kedars. Given the treacherous weather in the region, this temple opens to devotees only between the months of April to November each year.";
        String about4="Gol Gumbaz is located at Bijapur, now called Vijayapura, in the Karnataka state of India, at a distance of about 500 kilometers from the state capital Bengaluru. This place is a tomb of Sultan Adil Shah of Adil Shah Dynasty, his lover Rambha and his family. This monument’s ground floor is famous for the echoes, even the rattling of leaves sounds 7-8 times echoed. The name itself suggests it to be a “circular dome.";
        String about5="Every tourist place has that one spot which earns it galore and admiration. For Hampi, the small, dainty temple village set in Karnataka, it’s the iconic stone chariot. It’s the leading man in the army of exquisite beautiful sights that Hampi offers and depicts Karnataka tourism as an icon itself.The chariot is actually a shrine dedicated to Garuda, built inside the Vittala Temple Complex. The massive sculpture of Garuda, Lord Vishnu’s escort, once was seated atop the chariot but it is empty at the present date. The Hampi Chariot has earned its name among the other three famous stone chariots in India- One in Konark, Odissa, and the other in Mahabalipuram (Tamil Nadu).";
        String about6="Adiyogi Shiva Statue is the biggest Sculpture dedicated to the famous Hindu deity, Shiva. This huge sculpture is situated amidst lush green farms in the foothills of Velliangiri Mountains at Isha Yoga Complex in Coimbatore, Tamil Nadu. It was Inaugurated by Prime Minister of India, Narendra Modi on 24 February 2017 on the auspicious occasion of Maha Shivaratri.There’s also a famous Dhyanalinga temple inside the complex. During the placement of Sculpture, the Yogeshwar Linga was placed in front of the Sculpture through the ceremony of pran pratishtha. The temple also hosts a special light and sound show about Shiva as Yogi, which was inaugurated by Ram Nath Kovind, the President of India ";
        String about7="Kudremukh literally means horse’s face in Kannada. This name is because of the distinctive shape of the peak. This is also called Samseparvath historically, as it used to be accessible from Samse village.Kudremukh peak is nestled in the heart of the western ghats in Chikkamagaluru district. It comes under Kudremukh National Park which is the second-largest wildlife protected area in the western ghats.It is situated at an altitude of 6,207 ft and is the 3rd highest peak of Karnataka after Mullayyangiri and Baba Budangiri.";

        placeDetailsList.add(new placeDetails("Palace Mysore,karnataka,India.", about1, "500 rupees", R.drawable.img_3,5f));
        placeDetailsList.add(new placeDetails("Taj Mahal,India.", about2, "1000 rupees", R.drawable.img_4,4.5f));
        placeDetailsList.add(new placeDetails("Loard Shiva Temple Kedaranat,India.", about3, "5000 rupees", R.drawable.img_5,4.5f));
        placeDetailsList.add(new placeDetails("Gol Gumbaz Bijapur,karnataka,India.", about4, "1000 rupees", R.drawable.img_6,4f));
        placeDetailsList.add(new placeDetails("Stone chariot Hampi,karnataka,India.", about5, "1000 rupees", R.drawable.img_7,4.5f));
        placeDetailsList.add(new placeDetails("Adiyogi shiva statue coimbatore,Tamil Nadu", about6, "500 rupees", R.drawable.img_9,4.5f));
        placeDetailsList.add(new placeDetails("Kuduremuk trek chikamangalur,karnataka,India.", about7, "500 rupees", R.drawable.img_10,4f));


        likedDataList = new ArrayList<>();

        likedDataList.add(new likedData("Mysore Palace", "Mysore,karnataka,India.", "From 500 rupees", R.drawable.img_3));
        likedDataList.add(new likedData("Taj Mahal", "India.", "From 1000 rupees", R.drawable.img_4));
        likedDataList.add(new likedData("Loard Shiva Temple", "Kedaranat,India.", "From 2000 rupees", R.drawable.img_5));
        likedDataList.add(new likedData("Gol Gumbaz", "Bijapur,karnataka,India.", "From 500 rupees", R.drawable.img_6));
        likedDataList.add(new likedData("Stone chariot", "Hampi,karnataka,India.", "From 500 rupees", R.drawable.img_7));
        likedDataList.add(new likedData("Adiyogi shiva statue", "coimbatore,Tamil Nadu.", "From 500 rupees", R.drawable.img_9));
        likedDataList.add(new likedData("Kuduremuk trek", "chikamangalur,karnataka,India.", "From 500 rupees", R.drawable.img_10));

        setRecentRecycler(likedDataList,placeDetailsList);
    }

    private void setRecentRecycler(List<likedData> LikedDataList,  List<placeDetails> placeDetailsList) {

        recyclerView = findViewById(R.id.liked_recycler1);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        likedAdapter = new likedAdapter_seeAll(this, LikedDataList,placeDetailsList);
        recyclerView.setAdapter(likedAdapter);
    }
}


