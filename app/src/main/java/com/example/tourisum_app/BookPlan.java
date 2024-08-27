package com.example.tourisum_app;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tourisum_app.connectionDB.Conn_DB_Frg;

import java.util.Calendar;


public class BookPlan extends AppCompatActivity {
    Button book;
    EditText name,ph_nr,place,utr;
    TextView dateTextView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_plan);

        //back to  dashboard
        imageView=findViewById(R.id.back);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BookPlan.this,Dashboard.class);
                startActivity(intent);
            }
        });

        book=findViewById(R.id.book);
        name=findViewById(R.id.name);
        ph_nr=findViewById(R.id.phone_nr);
        place=findViewById(R.id.place);
        utr=findViewById(R.id.utr_nr);
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




        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Conn_DB_Frg obj=new Conn_DB_Frg(BookPlan.this);

                String n=name.getText().toString();
                String pn=ph_nr.getText().toString();
                String p=place.getText().toString();
                String u= utr.getText().toString();
                String d=dateTextView.getText().toString();

                if(n.equals("") || pn.equals("") || p.equals("") || u.equals("") || d.equals("")){
                    Toast.makeText(BookPlan.this, "Please enter all fields.", Toast.LENGTH_LONG).show();
                }
                else if (pn.length()!=10) {
                    Toast.makeText(BookPlan.this, "Enter valid phone nr.", Toast.LENGTH_LONG).show();

                }
                else {
                   obj.add(n,pn,p,d,u);
                    Intent intent=new Intent(BookPlan.this,Dashboard.class);
                    startActivity(intent);

                }

            }
        });




    }
}