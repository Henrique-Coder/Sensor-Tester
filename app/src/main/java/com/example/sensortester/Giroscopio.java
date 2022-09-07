package com.example.sensortester;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Giroscopio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giroscopio);
    }
    public void irMenu(View view){
        Intent menu = new Intent(this, MainActivity.class);
        startActivity(menu);
    }
}