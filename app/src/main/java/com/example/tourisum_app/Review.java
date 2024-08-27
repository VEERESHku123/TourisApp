package com.example.tourisum_app;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;


import java.util.Calendar;

public class Review extends AppCompatActivity {

    Button btn;
    RadioGroup radioGroup1,radioGroup2;
    EditText editText1,editText2;
    TextView dateTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        dateTextView=findViewById(R.id.dateTextView);

        dateTextView.setOnClickListener(v ->{
            // Get Current Date
            final Calendar c=Calendar.getInstance();
            int year=c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog=new DatePickerDialog(this,
                    (view, year1, monthOfYear, dayOfMonth) -> {
                        //set selected date
                        dateTextView.setText(dayOfMonth + "-" + (monthOfYear+1) + "-" + year1);
                    },year,month,day);
            datePickerDialog.show();
        } );

        btn=findViewById(R.id.submit);
        radioGroup1=findViewById(R.id.radioGroup1);
        editText1=findViewById(R.id.editText1);
        editText2=findViewById(R.id.editText2);
        radioGroup2=findViewById(R.id.radioGroup2);

        String placeName=editText1.getText().toString();
        String date=dateTextView.getText().toString();
        int check1=radioGroup1.getCheckedRadioButtonId();
        int check2=radioGroup2.getCheckedRadioButtonId();
        String review=editText2.getText().toString();

        RadioButton radioButton1=findViewById(check1);
        RadioButton radioButton2=findViewById(check2);
        btn.setOnClickListener(v -> {
            if(radioButton1==null || radioButton2==null || placeName.isEmpty() || date.isEmpty() || review.isEmpty() ){
                Toast.makeText(Review.this,"Please fill all fields.",Toast.LENGTH_LONG).show();

            }
            else {
                Intent intent=new Intent(Review.this,Dashboard.class);
                startActivity(intent);
            }


        });

    }
}