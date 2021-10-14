package com.example.lightson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class IniciarSesion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);
    }
    public void Olvidar (View view){
        Intent olvido = new Intent(this, ContrasenaOlvidada.class);
        startActivity(olvido);
    }
    public void Ingresar (View view){
        Intent ingreso = new Intent(this, ContrasenaOlvidada.class);
        startActivity(ingreso);
    }
}