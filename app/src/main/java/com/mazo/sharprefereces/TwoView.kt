package com.mazo.sharprefereces

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class TwoView : AppCompatActivity() {
    var txtUsuario: TextView?= null
    var txtPass: TextView?= null

        @SuppressLint("MissingInflatedId")
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_two_view)
            val btnButton: Button? = findViewById(R.id.btnMostrar)
            btnButton?.setOnClickListener { cargarDatos() }

            txtUsuario = findViewById(R.id.txtUser)
            txtPass = findViewById(R.id.txtPassword)

        }
        private fun cargarDatos() {
            var preferences: SharedPreferences =getSharedPreferences("credenciales", Context.MODE_PRIVATE)

            var user: String? =preferences.getString("user","No existe la información")
            var pass: String? =preferences.getString("pass","No existe la información")

            var editor:SharedPreferences.Editor=preferences.edit()
            editor.putString("user",user)
            editor.putString("pass",pass)

            editor.commit()

            txtUsuario?.text=user
            txtPass?.text=pass

        }
    }