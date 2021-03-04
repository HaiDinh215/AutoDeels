package com.project.AutoDeelsoftwareproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class signup_login extends AppCompatActivity {

    private ImageButton login_btn;
    private ImageButton signup_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_login);

        login_btn = findViewById(R.id.login_btn_big);
        signup_btn = findViewById(R.id.signup_btn_big);
        //navigate to login screen
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLoginActivity();
            }
        });
        //navigate to sign up screen
        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSignupActivity();
            }
        });
    }

    public void openLoginActivity(){
        Intent loginIntent = new Intent(this,Login.class);
        startActivity(loginIntent);
    }

    public void openSignupActivity(){
        Intent signupIntent = new Intent(this,Signup.class);
        startActivity(signupIntent);
    }
}