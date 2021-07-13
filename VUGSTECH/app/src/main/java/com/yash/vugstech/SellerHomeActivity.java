package com.yash.vugstech;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

    public class SellerHomeActivity extends AppCompatActivity {
        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_sellerhome);
            Button addproduct = (Button) findViewById(R.id.buttonProfile4);
            Button profilebut = (Button) findViewById(R.id.buttonProfile1);


            addproduct.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity((new Intent(getApplicationContext(), SellerAddProducts.class)));
                }
            });

            profilebut.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity((new Intent(getApplicationContext(), SellerAddProducts.class)));
                }
            });
        }
    }
