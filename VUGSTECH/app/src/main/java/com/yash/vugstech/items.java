package com.yash.vugstech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class items extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);
        ImageButton imgButton1 =(ImageButton)findViewById(R.id.imageButton1);
        ImageButton imgButton2 =(ImageButton)findViewById(R.id.imageButton2);
        ImageButton imgButton3 =(ImageButton)findViewById(R.id.imageButton3);
        ImageButton imgButton4 =(ImageButton)findViewById(R.id.imageButton4);
        imgButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Groceries.class));
                Toast.makeText(items.this, "Searching for groceries", Toast.LENGTH_LONG);
            }
        });
        imgButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MilkProducts.class));
                Toast.makeText(items.this, "Searching for milk products", Toast.LENGTH_LONG);
            }
        });
        imgButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),ElectronicItems.class));
                Toast.makeText(items.this, "Searching for electronic items", Toast.LENGTH_LONG);
            }
        });
        imgButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),OtherItems.class));
                Toast.makeText(getApplicationContext(),"Searching for other items",Toast.LENGTH_LONG).show();
            }
        });
    }
}