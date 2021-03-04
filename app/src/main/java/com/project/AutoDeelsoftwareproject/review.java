package com.project.AutoDeelsoftwareproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class review extends AppCompatActivity {

    private TextView button;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review);
        button = findViewById(R.id.textView11);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button();
            }

        });

    }

    private void button() {
    }

    public void clickOnTextView(){
        Intent intent = new Intent(this, payment.class);
        startActivity(intent);
    }
}
