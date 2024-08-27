package com.example.tourisum_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tourisum_app.connectionDB.Connection_db;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class login extends AppCompatActivity {
    GoogleSignInOptions gso;
   GoogleSignInClient gsc;
    ImageView googleBtn;
    Button btn;
    EditText ed1,ed2;
    TextView textView;
    Connection_db db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //normal button login
        btn=findViewById(R.id.login);
        ed1=findViewById(R.id.username);
        ed2=findViewById(R.id.password);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = ed1.getText().toString().trim();
                String password = ed2.getText().toString().trim();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(login.this, "Please enter all fields.", Toast.LENGTH_LONG).show();
                }
                else {
                        Intent i= new Intent(login.this, Dashboard.class);
                        startActivity(i);

                }
            }
        });

        //register btn
        textView=findViewById(R.id.register);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(login.this,Register.class);
                startActivity(intent);
            }
        });




        //google btn signin
        googleBtn=findViewById(R.id.googleBtn);

        gso=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc= GoogleSignIn.getClient(this,gso);

        googleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sigin();

            }
        });


    }

    void sigin(){
        Intent signInIntent=gsc.getSignInIntent();
        startActivityForResult(signInIntent,1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1000){
            Task<GoogleSignInAccount> task=GoogleSignIn.getSignedInAccountFromIntent(data);

            try {
                task.getResult(ApiException.class);
                navigateToSecondActivity();

            }
            catch (ApiException e){
                Toast.makeText(getApplicationContext(),"Something went wrong.",Toast.LENGTH_LONG).show();

            }

        }
    }

    void navigateToSecondActivity(){
        finish();
        Intent intent=new Intent(login.this,Dashboard.class);
        startActivity(intent);

    }

}