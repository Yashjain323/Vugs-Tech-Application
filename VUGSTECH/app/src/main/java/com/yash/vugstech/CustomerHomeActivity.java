package com.yash.vugstech;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CustomerHomeActivity extends AppCompatActivity {
        Button addproductBtn;
        Button profileButton;
        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_customerhome);

            addproductBtn = (Button) findViewById(R.id.buttonProfile4);
            addproductBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MyDialog myDialog = new MyDialog();
                    myDialog.show(getSupportFragmentManager(),"123");
                    startActivity(new Intent(getApplicationContext(),CustomerDecide.class));
                }
            });
            profileButton = (Button)findViewById(R.id.buttonProfile1);
            profileButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getApplicationContext(),ProfileManage.class));
                }
            });

        }
}
