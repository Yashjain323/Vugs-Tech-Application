package com.yash.vugstech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class CustomerDecide extends AppCompatActivity {
    Button Button1 =(Button)findViewById(R.id.search);
    Button Button2 =(Button)findViewById(R.id.list);
    ImageButton Button3 = (ImageButton)findViewById(R.id.locationButton);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_decide);
        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),CustomerSearch.class));
                Toast.makeText(getApplicationContext(),
                        "Type in the search",Toast.LENGTH_LONG).show();
                MyDialog2 myDialog2 = new MyDialog2();
                myDialog2.show(getSupportFragmentManager(),"123");
            }
        });
        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),items.class));
                Toast.makeText(CustomerDecide.this,"Search from the list",Toast.LENGTH_LONG).show();
            }
        });
        Button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LocationTracker.class));
                Toast.makeText(CustomerDecide.this, "Your Location!", Toast.LENGTH_LONG).show();
            }
        });
    }
}