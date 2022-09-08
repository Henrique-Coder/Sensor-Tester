package com.example.sensortester;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class GPS extends AppCompatActivity {

        TextView textocoordenadas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);
        textocoordenadas = (TextView)findViewById(R.id.textView3);
        getSupportActionBar().hide();
    }

    public void buscarlocalizacao(View v){
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(GPS.this, new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            ActivityCompat.requestPermissions(GPS.this, new String[] {Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
            return;
        }
        LocationManager mLocManager = (LocationManager) getSystemService(GPS.this.LOCATION_SERVICE);
        LocationListener mLocListener = new XYZCoordenadas();

        mLocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3000, 0, mLocListener);

        if(mLocManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            String coordinatestext = "Latitude:" + XYZCoordenadas.latitude + "\n" +
                                     "Longitude:" + XYZCoordenadas.longitude;
            textocoordenadas.setText(coordinatestext);
            Toast.makeText(GPS.this, "Sensor Funcionando", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(GPS.this, "Erro", Toast.LENGTH_LONG).show();
        }
    }
    public void irMenu(View view){
        Intent menu = new Intent(this, MainActivity.class);
        startActivity(menu);
    }


    public void onSensorChanged(SensorEvent event) {

    }


    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    public void irMaps(View view){
        Intent map = new Intent(android.content.Intent.ACTION_VIEW);
        map.setData(Uri.parse("geo: " + XYZCoordenadas.latitude + "," + XYZCoordenadas.longitude));
        startActivity(map);

    }
}