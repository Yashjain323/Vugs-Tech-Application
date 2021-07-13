package com.yash.vugstech;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProfileManage extends AppCompatActivity {
    private ImageView imageView;
    DatabaseReference dbref = FirebaseDatabase.getInstance("https://vugs-tech-default-rtdb.firebaseio.com").getReference("Customer");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_manage);
        imageView = (ImageView)this.findViewById(R.id.imageViewseller);
        Button photoButton = (Button) this.findViewById(R.id.button30);
        EditText email = (EditText) findViewById(R.id.editTextEmailAddressseller);
        EditText name = (EditText) findViewById(R.id.editTextNameseller);
        EditText address = (EditText) findViewById(R.id.useraddress2seller);
        EditText useraddressInput = (EditText) findViewById(R.id.useraddress1);
        EditText emailIDInput = (EditText) findViewById(R.id.emailID);
        EditText fNameInput = (EditText) findViewById(R.id.fName);
        EditText lNameInput = (EditText) findViewById(R.id.lName);
        email.setText((String)emailIDInput.getText().toString().trim());
        name.setText(fNameInput + " " + lNameInput);
        address.setText(useraddressInput.getText().toString().trim());
        ImageView img2 = (ImageView) findViewById(R.id.imageView7seller);
        ImageView img3 = (ImageView) findViewById(R.id.imageView8seller);
        ImageView img5 = (ImageView) findViewById(R.id.imageView6seller);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbref.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("fname").setValue(name.getText());
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbref.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("emailId").setValue(email.getText());
            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbref.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("address").setValue(address.getText());
            }
        });
        ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            // There are no request codes
                            Intent data = result.getData();
                            Bitmap photo = (Bitmap) data.getExtras().get("data");
                            imageView.setImageBitmap(photo);
                            }
                        }
                });
        photoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                someActivityResultLauncher.launch(cameraIntent);
                //Intent photoIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                //someActivityResultLauncher1.launch(photoIntent);
            }
        });
    }
}
