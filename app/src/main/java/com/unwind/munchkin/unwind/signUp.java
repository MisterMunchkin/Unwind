package com.unwind.munchkin.unwind;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class signUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }
    public void logInView(View view){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
