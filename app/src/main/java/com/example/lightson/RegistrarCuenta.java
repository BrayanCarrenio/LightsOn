package com.example.lightson;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import java.util.HashMap;
import java.util.Map;


public class RegistrarCuenta extends AppCompatActivity {

    private EditText editTextUsuario;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private EditText editTextRepeatPass;
    private Button buttonRegister;

    //variables de los datos a registrar
    private String usuario = "";
    private String email="";
    private String password="";
    private String repeatpassword="";

    FirebaseAuth mAuth;
    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_cuenta);

        mAuth=FirebaseAuth.getInstance();
        mDatabase= FirebaseDatabase.getInstance().getRefenrence();

        editTextUsuario=(EditText) findViewById(R.id.txt_Nombre);
        editTextEmail=(EditText) findViewById(R.id.txt_Correo);
        editTextPassword=(EditText) findViewById(R.id.txt_Contas);
        editTextRepeatPass=(EditText) findViewById(R.id.txt_RepetirContras);
        buttonRegister = (Button) findViewById(R.id.botonCrear);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usuario=editTextUsuario.getText().toString();
                email=editTextEmail.getText().toString();
                password=editTextPassword.getText().toString();
                repeatpassword=editTextRepeatPass.getText().toString();

                if (!usuario.isEmpty() && !email.isEmpty() && !password.isEmpty()
                        && !repeatpassword.isEmpty()){

                    if (password.length()>=6){

                    } else
                    {
                        Toast.makeText( RegistrarCuenta.this, "La contraseña debe tener minimo 6 caracteres", Toast.LENGTH_SHORT).show();
                    }
                    if (password==repeatpassword){

                    }else{
                        Toast.makeText( RegistrarCuenta.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                    }
                    registerUser();
                }else{
                    Toast.makeText( RegistrarCuenta.this, "Debes completar los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void registrarUsuario(){
        mAuth.createUserWithEmailAndPassword(email, password). addOnCompleteListener(new OnCompleteListener<AuthResult>(){
            @Override
            public void onComplete(@NonNullTask<AuthResult> task){
                if(task.isSuccessful()){
                    Map<String, Object> map= new HashMap<>();
                    map.put("name", usuario);
                    map.put("email", email);
                    map.put("password", password);
                    String id = mAuth.getCurrenUser().getUid();
                    mDatabase.child("Users").child(id).setValue(map). addOnCompleteListener(new OnCompleteListener<Void>(){
                        @Override
                        public void onComplete(@NonNull Task<Void> task2){
                            if (task2.isSuccessful()){
                                startActivity(new Intent(RegistrarCuenta.this, IniciarSesion.class));
                                finish();
                            }
                            else{
                                Toast.makeText( RegistrarCuenta.this, "No se crearon los datos correctamente", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } else{
                    Toast.makeText( RegistrarCuenta.this, "No se puede registrar el usuario", Toast.LENGTH_SHORT).show();
                }
            }
        }
        );
    }
}