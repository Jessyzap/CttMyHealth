package com.example.myhealth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.hide()
        mostrarTelaCadastro()
    }

    fun mostrarTelaCadastro() {
        Handler(
            Looper.getMainLooper()).postDelayed({
            val telaCadastro =
                Intent(this, CadastroActivity::class.java)
            startActivity(telaCadastro)
            finish()
        }, 3000)}
}