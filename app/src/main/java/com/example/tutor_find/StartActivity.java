package com.example.tutor_find;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class StartActivity extends AppCompatActivity {

    Button login, register;

    private FirebaseUser firebaseUser;

    @Override
    protected void onStart() {
        super.onStart();
        getSupportActionBar().hide();

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if(firebaseUser != null)
        {
            if(firebaseUser.isEmailVerified())
            {
                startActivity(new Intent(StartActivity.this, MainActivity.class));
                finish();
            }
            else
            {
                Toast.makeText(StartActivity.this, "Please Verify Your Email.", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(StartActivity.this, LoginActivity.class));
                finish();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        login = findViewById(R.id.login);
        register = findViewById(R.id.register);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartActivity.this,LoginActivity.class));
                finish();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartActivity.this, TeacherRegActivity.class));
                finish();
            }
        });
    }
}
