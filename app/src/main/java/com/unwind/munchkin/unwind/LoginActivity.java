package com.unwind.munchkin.unwind;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void signUpView(View view){
        Intent intent = new Intent(this, signUp.class);
        startActivity(intent);
    }

    public void launchingView(View view){
        Intent intent = new Intent(this, LaunchingPage.class);
        startActivity(intent);
    }
}
