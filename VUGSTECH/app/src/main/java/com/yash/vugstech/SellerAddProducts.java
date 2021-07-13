package com.yash.vugstech;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SellerAddProducts extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    Spinner productaddspinner;
    EditText editText = (EditText) findViewById(R.id.editTextPersonName);
    EditText editText2 = (EditText) findViewById(R.id.editTextPhone);
    EditText editText3 = (EditText) findViewById(R.id.editTextMultiLine);
    EditText editText4 = (EditText) findViewById(R.id.editTextNumber);
    Button button1 = (Button) findViewById(R.id.button2);
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("VUGS TECH");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        productaddspinner = (Spinner) findViewById(R.id.spinner);
        productaddspinner.setOnItemSelectedListener(this);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.producttype));
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        productaddspinner.setAdapter(spinnerAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
        String type = parent.getItemAtPosition(i).toString().trim().toLowerCase();
        String shopname = String.valueOf(editText.getText());
        String productItem = String.valueOf(editText2.getText());
        Double price = Double.valueOf(String.valueOf(editText3.getText()));
        Double contact = Double.valueOf(String.valueOf(editText4.getText()));
        Product userinfo = new Product(shopname, productItem, price, contact);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // We only handle one button
                myRef.child(type).child(productItem).child(shopname).setValue(userinfo);
            }
        });

    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(this, "Please Select an Option", Toast.LENGTH_LONG).show();
    }
}
