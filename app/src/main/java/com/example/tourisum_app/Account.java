package com.example.tourisum_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tourisum_app.connectionDB.Connection_db;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class Account extends AppCompatActivity {

    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    TextView name ,email;
    Button signout;
    ImageView ToDashboard;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        name=findViewById(R.id.textView1);
        email=findViewById(R.id.textView2);
        signout=findViewById(R.id.logout);




        gso=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc= GoogleSignIn.getClient(this,gso);

        GoogleSignInAccount acc=GoogleSignIn.getLastSignedInAccount(this);
        if(acc!=null){
            String personName=acc.getDisplayName();
            String personEmail=acc.getEmail();
            name.setText(personName);
            email.setText(personEmail);

        }

        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sigOut();
            }
        });

        //Back to dashboard button
        ToDashboard=findViewById(R.id.backTo);
        ToDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Account.this,Dashboard.class);
                startActivity(intent);
            }
        });


    }

    void sigOut(){
        gsc.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(Task<Void> task) {
                finish();
                Intent intent=new Intent(Account.this,MainActivity.class);
                startActivity(intent);

            }
        });
    }
}