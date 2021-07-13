package com.yash.vugstech;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SellerRegistrationActivity extends AppCompatActivity {
    String fName;
    String lName;
    String useraddress;
    String emailID;
    String password;
    String confirmpassword;

    EditText fNameInput;
    EditText lNameInput;
    EditText useraddressInput;
    EditText emailIDInput;
    EditText passwordInput;
    EditText confirmpasswordInput;

    private FirebaseAuth firebaseAuth;
    DatabaseReference dbref;

    Button signup_Btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sellerregistration);

        fNameInput = (EditText) findViewById(R.id.fName);
        lNameInput = (EditText) findViewById(R.id.lName);
        useraddressInput = (EditText) findViewById(R.id.useraddress1);
        emailIDInput = (EditText) findViewById(R.id.emailID);
        passwordInput = (EditText) findViewById(R.id.passwordField);
        confirmpasswordInput = (EditText) findViewById(R.id.confirmpasswordField);
        signup_Btn = (Button) findViewById(R.id.signupBtn);
        firebaseAuth = FirebaseAuth.getInstance();

        dbref = FirebaseDatabase.getInstance().getReference("Seller");
        firebaseAuth = FirebaseAuth.getInstance();

        signup_Btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                fName = fNameInput.getText().toString().trim();
                lName = lNameInput.getText().toString().trim();
                useraddress = useraddressInput.getText().toString().trim();
                emailID = emailIDInput.getText().toString().trim();
                password = passwordInput.getText().toString().trim();
                confirmpassword = confirmpasswordInput.getText().toString().trim();

                if(TextUtils.isEmpty(fName)) {
                    Toast.makeText(SellerRegistrationActivity.this, "Please Enter FirstName",Toast.LENGTH_LONG);
                    return;
                }if(TextUtils.isEmpty(lName)) {
                    Toast.makeText(SellerRegistrationActivity.this, "Please Enter LastName",Toast.LENGTH_LONG);
                    return;
                }if(TextUtils.isEmpty(useraddress)) {
                    Toast.makeText(SellerRegistrationActivity.this, "Please Enter Address",Toast.LENGTH_LONG);
                    return;
                }
                if(TextUtils.isEmpty(emailID)) {
                    Toast.makeText(SellerRegistrationActivity.this, "Please Enter EmailId",Toast.LENGTH_LONG);
                    return;
                }
                if(TextUtils.isEmpty(password)) {
                    Toast.makeText(SellerRegistrationActivity.this, "Please Enter Password",Toast.LENGTH_LONG);
                    return;
                }
                if(TextUtils.isEmpty(confirmpassword)) {
                    Toast.makeText(SellerRegistrationActivity.this, "Please Enter ConfirmPassword",Toast.LENGTH_LONG);
                    return;
                }

                if(password.equals(confirmpassword)){
                    firebaseAuth.createUserWithEmailAndPassword(emailID, password)
                            .addOnCompleteListener(SellerRegistrationActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {

                                        Seller userinfo = new Seller(fName,lName,useraddress,emailID);
                                        FirebaseDatabase.getInstance().getReference("Seller")
                                                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                                .setValue(userinfo).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                                Toast.makeText(SellerRegistrationActivity.this,"Registered Successfully",Toast.LENGTH_LONG);

                                            }
                                        });

                                    } else {
                                        Toast.makeText(SellerRegistrationActivity.this,"Authentication Failed",Toast.LENGTH_LONG);

                                    }


                                }
                            });
                }
                else {
                    Toast.makeText(SellerRegistrationActivity.this, "Please Confirm Password Correctly",Toast.LENGTH_LONG);
                }
            }
        });
    }
}
