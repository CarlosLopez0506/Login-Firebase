package com.example.prueba

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class Menu_Principal : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth;

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_principal)

        auth = Firebase.auth
        var saludoMenu = findViewById<TextView>(R.id.textMenuPrincipal)
        var btnVolverLogin = findViewById<Button>(R.id.botonMenuPrincipal)
        var parametro = intent.extras

        saludoMenu.text =
            saludoMenu.text.toString() + " " + parametro?.getCharSequence("nombre").toString()
        btnVolverLogin.setOnClickListener {
            startActivity(Intent(this, Login::class.java))

        }
    }

    public override fun onDestroy() {
        super.onDestroy()
        auth.signOut()
    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if (currentUser != null) {
            Toast.makeText(this, "Autenticación etxitosa", Toast.LENGTH_LONG).show()
        } else {
            finish()
        }
    }
}