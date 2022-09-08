package com.example.sensortester;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Camera extends AppCompatActivity {
    private static final int CAPTURA_IMAGEM = 1;
    private Uri uri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        getSupportActionBar().hide();
    }

    public void irMenu(View view) {
        Intent menu = new Intent(this, MainActivity.class);
        startActivity(menu);
    }

    public void tirarfoto(View v) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, CAPTURA_IMAGEM);
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAPTURA_IMAGEM) {
            if (resultCode == RESULT_OK) {
                Bundle extras = data.getExtras();
                Bitmap imageBitmap = (Bitmap) extras.get("data");
                ImageView imageView = (ImageView) findViewById(R.id.imageView);
                imageView.setImageBitmap(imageBitmap);
                mostrarMensagem("Imagem capturada!");
                adicionarNaGaleria();
            } else {
                mostrarMensagem("Imagem não capturada!");
            }
        }
        if (resultCode == Activity.RESULT_OK && requestCode == 123) {
            Uri imagemSelecionada = data.getData();
            //ImageView imageView = (ImageView) findViewById(R.id.imageView);
            ImageView imageView = new ImageView(this);
            imageView.setImageURI(imagemSelecionada);
            ConstraintLayout ln = (ConstraintLayout) findViewById(R.id.constraintlayout);
            ln.addView(imageView);
        }
    }

    private void mostrarMensagem(String msg) {
        Toast.makeText(this, msg,
                        Toast.LENGTH_LONG)
                .show();
    }
    private void adicionarNaGaleria() {
        Intent intent = new Intent(
                Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        intent.setData(uri);
        this.sendBroadcast(intent);
    }
}