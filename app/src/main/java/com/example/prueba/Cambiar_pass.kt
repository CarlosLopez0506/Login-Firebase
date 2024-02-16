package com.example.prueba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Cambiar_pass : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cambiar_pass)

        var saludoCrear = findViewById<TextView>(R.id.textCambiarPass);
        var btnVolverLogin = findViewById<Button>(R.id.botonCambiarPass);

        btnVolverLogin.setOnClickListener{
            startActivity(Intent(this, Login::class.java))

        }
    }
}