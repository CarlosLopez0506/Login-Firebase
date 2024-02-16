package com.example.prueba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Crear_cuenta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_cuenta)

        var saludoCrear = findViewById<TextView>(R.id.textCrearCuenta);
        var btnVolverLogin = findViewById<Button>(R.id.botonCrearCuenta);

        btnVolverLogin.setOnClickListener{
            startActivity(Intent(this, Login::class.java))
        }
    }
}