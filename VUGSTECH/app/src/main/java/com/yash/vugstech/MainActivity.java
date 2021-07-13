package com.yash.vugstech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button sellerBtn, customerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customerBtn = (Button)findViewById(R.id.search);
        sellerBtn = (Button)findViewById(R.id.list);

        customerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity((new Intent(getApplicationContext(), CustomerLogin.class)));
            }
        });

        sellerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity((new Intent(getApplicationContext(), SellerLoginActivity.class)));
            }
        });
    }
}