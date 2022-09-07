package com.example.sensortester;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void IrGPS(View view){
        Intent gps = new Intent(this, GPS.class);
        startActivity(gps);
    }
    public void IrGiroscopio(View view){
        Intent giroscopio = new Intent(this, Giroscopio.class);
        startActivity(giroscopio);
    }
    public void IrCamera(View view){
        Intent camera = new Intent(this, Camera.class);
        startActivity(camera);
    }
    public void IrLanterna(View view){
        Intent lanterna = new Intent(this, Lanterna.class);
        startActivity(lanterna);
    }
    public void IrAjuda(View view){
        Intent ajuda = new Intent(this, Ajuda.class);
        startActivity(ajuda);
    }
}