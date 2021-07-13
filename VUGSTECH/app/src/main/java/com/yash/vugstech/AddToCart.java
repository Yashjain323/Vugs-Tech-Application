package com.yash.vugstech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class AddToCart extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_cart);
        LinearLayout mainLayout = (LinearLayout)findViewById(R.id.linear1);
        View view = getLayoutInflater().inflate(R.layout.cardview, mainLayout,false);
        mainLayout.addView(view);
    }
}