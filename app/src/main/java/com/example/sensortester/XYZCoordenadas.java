package com.example.sensortester;

import android.location.Location;
import android.location.LocationListener;

import androidx.annotation.NonNull;

public class XYZCoordenadas implements LocationListener {
        public static double latitude;
        public static double longitude;



    @Override
    public void onLocationChanged(@NonNull Location location) {
        this.latitude = location.getLatitude();
        this.longitude = location.getLongitude();
    }
}
