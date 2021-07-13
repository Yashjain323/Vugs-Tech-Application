package com.yash.vugstech;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class OtherItems extends Activity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("VUGS TECH");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_items);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.activity_listview,
                getResources().getStringArray(R.array.otheritems));

        ListView listView = (ListView)findViewById(R.id.otherItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                myRef.orderByChild("productItem").equalTo(selectedItem).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Product product = dataSnapshot.getValue(Product.class);
                        EditText edit= (EditText)findViewById(R.id.edit_text1);
                        edit.setText("Shop = " + product.shopname + "\n" +"Product = " + product.productItem + "/n"
                                + "Contact Number = " + product.contact + "\n" + "Cost = " + product.price);
                        setContentView(R.layout.activity_customer_search);
                    }
                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                    }
                });


                //textView.setText("The best football player is : " + selectedItem);
            }
        });
    }
}