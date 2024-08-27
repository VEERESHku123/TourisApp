package com.example.tourisum_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tourisum_app.connectionDB.Connection_db;

public class Register extends AppCompatActivity {
    EditText FirstName,LastName,Username,Password;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Edit Text
        FirstName=findViewById(R.id.first_name);
        LastName=findViewById(R.id.last_name);
        Username=findViewById(R.id.username);
        Password=findViewById(R.id.password);

        //register btn
        btn=findViewById(R.id.register);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Connection_db obj=new Connection_db(Register.this);

               String fname=FirstName.getText().toString();
               String lname=LastName.getText().toString();
               String user=Username.getText().toString();
               String pass=Password.getText().toString();

               if(fname.equals("") || lname.equals("") || user.equals("") || pass.equals("")){
                   Toast.makeText(Register.this, "Please enter all fields.", Toast.LENGTH_LONG).show();
               }
               else {
                   obj.addUser(fname,lname,user,pass);
                   Toast.makeText(Register.this, "Register done succsefully.", Toast.LENGTH_LONG).show();
                   Intent intent=new Intent(Register.this,login.class);
                   startActivity(intent);
               }

            }
        });
    }

}