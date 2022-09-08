package com.example.sensortester;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Lanterna extends AppCompatActivity {

    private Button funcionamento;

    boolean LanternaStatus = false;
    boolean LanternaLigada = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lanterna);
        getSupportActionBar().hide();

        funcionamento = findViewById(R.id.button7);

        LanternaStatus = getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
    }
    public void irMenu(View view){
        Intent menu = new Intent(this, MainActivity.class);
        startActivity(menu);
    }
    public void Clique(View v){
        if(LanternaStatus){
            Toast.makeText(Lanterna.this, "A lanterna do aparelho está funcionando", Toast.LENGTH_LONG).show();
            if(LanternaLigada){
                LanternaLigada = false;
                funcionamento.setText("Ligar");
                try {
                    DesligaLanterna();
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                }
            }
            else{
                LanternaLigada = true;
                funcionamento.setText("Desligar");
                try {
                    LigaLanterna();
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        else{
            Toast.makeText(Lanterna.this, "O aparelho não possui lanterna", Toast.LENGTH_LONG).show();
        }
    }

    private void LigaLanterna() throws CameraAccessException {
        CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        String cameraId = cameraManager.getCameraIdList()[0];
        cameraManager.setTorchMode(cameraId, true);
    }
    private void DesligaLanterna() throws CameraAccessException {
        CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        String cameraId = cameraManager.getCameraIdList()[0];
        cameraManager.setTorchMode(cameraId, false);
    }
}