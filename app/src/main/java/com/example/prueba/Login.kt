package com.example.prueba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class Login : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = Firebase.auth
        var saludoLogin = findViewById<TextView>(R.id.textLogin)
        var btnLogin = findViewById<TextView>(R.id.botonLogIn)
        var btnCrearCuenta = findViewById<TextView>(R.id.botonLogin2)
        var btnRecuperarPass = findViewById<TextView>(R.id.botonLogin3)

        btnLogin.setOnClickListener {
            auth.signInWithEmailAndPassword("skibidi@toilet.com", "tilines")
                .addOnCompleteListener { task ->

                    if (task.isSuccessful) {

                        startActivity(
                            Intent(this, MenuPrincipal::class.java).putExtra(
                                "nombre",
                                "Carlos"
                            )
                        )
                    } else {
                        Toast.makeText(
                            this,
                            "Error: " + task.exception!!.message.toString(),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }
        btnCrearCuenta.setOnClickListener {
            startActivity(Intent(this, Crear_cuenta::class.java))

        }
        btnRecuperarPass.setOnClickListener {
            startActivity(Intent(this, Cambiar_pass::class.java))

        }

    }

//    public override fun onStart() {
//        super.onStart()
//        val currentUser = auth.currentUser
//        if (currentUser != null) {
//            Toast.makeText(this, "Ya estas autenticado", Toast.LENGTH_LONG).show()
//            startActivity(Intent(this, Menu_Principal::class.java).putExtra("nombre", "Carlos"))
//        }
//
//    }
}