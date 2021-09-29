package com.example.lightson;

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

    public void Registrarse (View view){
        Intent registro = new Intent(this, RegistrarCuenta.class);
        startActivity(registro);
    }
    public void IniciarSesion (View view){
        Intent inicio = new Intent(this, IniciarSesion.class);
        startActivity(inicio);
    }
}