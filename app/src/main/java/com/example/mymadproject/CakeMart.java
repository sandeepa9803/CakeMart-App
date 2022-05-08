package com.example.mymadproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class  CakeMart extends AppCompatActivity {

    Button updatedelete , add ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cake_mart);

        updatedelete    = findViewById(R.id.upDeleteBtn);
        add             = findViewById(R.id.AddBTn2);

        updatedelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(),MyApplication2.class);
                startActivity(i);

            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(),calculateapp.class);
                startActivity(i);
            }
        });
    }
}