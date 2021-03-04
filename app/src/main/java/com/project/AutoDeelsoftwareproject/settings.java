package com.project.AutoDeelsoftwareproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class settings extends AppCompatActivity {
    //Code by sarthak thakkar
    private static int number;
    private static final int REQUEST_PHONE_CALL = number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        TextView contact_txt_btn = findViewById(R.id.setting_contactus);

        //navigate to contact us screen
        contact_txt_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), contact_us.class);
                startActivity(intent);
            }
        });

        //code by sarthak thakkar
        //navigate to privacy page
//        privacy_txt_btn.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                Intent intent = new Intent(getApplicationContext(), privacy.class);
//                startActivity(intent);
//            }
//        });

    }
}