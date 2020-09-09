package com.daa.jappslider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PantallaLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_login);
    }
    public void iniciarSesion(View view){
        Intent intent =new Intent(this,SliderDeClases.class);
        startActivity(intent);
    }
}