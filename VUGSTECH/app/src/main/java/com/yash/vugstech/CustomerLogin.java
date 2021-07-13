package com.yash.vugstech;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class CustomerLogin extends AppCompatActivity {
    EditText txtlogin,txtpassword;
    Button loginBtn,registerBtn;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customelogin);

        txtlogin = (EditText)findViewById(R.id.loginField);
        txtpassword = (EditText)findViewById(R.id.passwordField);
        loginBtn = (Button)findViewById(R.id.loginBtn);
        registerBtn = (Button)findViewById(R.id.newUserBtn);

        firebaseAuth = FirebaseAuth.getInstance();

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = txtlogin.getText().toString().trim();
                String password = txtpassword.getText().toString().trim();

                firebaseAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(CustomerLogin.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    startActivity((new Intent(getApplicationContext(), CustomerHomeActivity.class)));
                                } else {
                                    Toast.makeText(CustomerLogin.this, "Login Failed or User not Available", Toast.LENGTH_LONG).show();
                                }

                            }
                        });

            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity((new Intent(getApplicationContext(), CustomerRegistrationActivity.class)));
            }
        });
    }
}

