package com.project.AutoDeelsoftwareproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class user_profile extends AppCompatActivity {

    FirebaseAuth mAuth;
    private ImageButton logout_btn;
    private TextView settings_text_btn;
    private TextView notification_text_btn;
    private TextView sell_btn;
//    private ImageView user_pic = findViewById(R.id.user_picture);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        mAuth = FirebaseAuth.getInstance();
        Intent intent = getIntent();
        String profileName = intent.getStringExtra(Login.EXTRA_TEXT);
        TextView userName = findViewById(R.id.user_name);
        userName.setText(profileName);

//        //code by sarthak thakkar
//        sell_btn = findViewById(R.id.sell_btn);

        logout_btn = findViewById(R.id.logout_btn);
        settings_text_btn = findViewById(R.id.settings_text_btn);
        notification_text_btn = findViewById(R.id.noti_text_btn);

        //code by sarthak thakkar
        //sell car button
//        sell_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), camera.class);
//                startActivity(intent);
//            }
//        });

        //logout
        logout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                Intent intent = new Intent(getApplicationContext(),signup_login.class);
                startActivity(intent);
            }
        });
        //navigate to setting screen
        settings_text_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSettings();
            }
        });
        //navigate to notification screen
        notification_text_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNotifications();
            }
        });
        //navigate to browse car screens(bottom navigation)
        TextView browsecar_txt_btn = findViewById(R.id.browse_txt_btn);
        browsecar_txt_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBrowsecarBottomnav();
            }
        });
        //user profile pic
//        user_pic.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
    }

    public void openSettings(){
        Intent intent = new Intent(this,settings.class);
        startActivity(intent);
    }

    public void openNotifications(){
        Intent intent = new Intent(this, notifications.class);
        startActivity(intent);
    }

    public void openBrowsecarBottomnav(){
        Intent intent = new Intent(this, browse_car_bottomnav.class);
        startActivity(intent);
    }
}