package com.example.lightson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ContrasenaOlvidada extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contrasena_olvidada);
    }
    public void NuevaContrasena (View view){
        Intent contrasenanuevo = new Intent(this, RecuperarContrasena.class);
        startActivity(contrasenanuevo);
    }
}