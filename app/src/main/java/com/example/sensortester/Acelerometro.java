package com.example.sensortester;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Acelerometro extends AppCompatActivity implements SensorEventListener {

    private TextView coordx, coordy, coordz;
    private Sensor sensor;
    private SensorManager sensormanager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acelerometro);
        getSupportActionBar().hide();
        sensormanager = (SensorManager) getSystemService(SENSOR_SERVICE);

        sensor = sensormanager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        sensormanager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);

        coordx = (TextView) findViewById(R.id.textView4);
        coordy = (TextView) findViewById(R.id.textView5);
        coordz = (TextView) findViewById(R.id.textView6);
        Toast.makeText(Acelerometro.this, "O Sensor está funcionando", Toast.LENGTH_LONG).show();
    }
    public void irMenu(View view){
        Intent menu = new Intent(this, MainActivity.class);
        startActivity(menu);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        coordx.setText("X: " + event.values[0]);
        coordy.setText("Y: " + event.values[1]);
        coordz.setText("Z: " + event.values[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}