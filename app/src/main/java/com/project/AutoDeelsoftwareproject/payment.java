package com.project.AutoDeelsoftwareproject;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class payment extends AppCompatActivity {

    private TextView visa, etransfer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment);

        //visa = findViewById(R.id.visa_method);
        etransfer = findViewById(R.id.etransfer_method);

    }
}