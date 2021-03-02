package com.example.myhealth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.SystemClock
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.myhealth.model.Exercicio
import kotlinx.android.synthetic.main.activity_yoga.*
import kotlin.time.milliseconds

class ExercicioActivity : AppCompatActivity() {
    private lateinit var nome: TextView
    private lateinit var imagemExercicio: ImageView
    private lateinit var botaoCronometro: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       // supportActionBar?.hide()  // Para tirar a barra com o nome do app.
        setContentView(R.layout.activity_yoga)

        nome = findViewById(R.id.nomeExercicio)
        imagemExercicio = findViewById(R.id.imgExercicio)
        botaoCronometro = findViewById(R.id.btnIniciarCronometro)

        val nomeRecebido = intent.getStringExtra("NOME")
        nome.text = nomeRecebido

        val imagemRecebida = intent.extras?.get("EXERCICIO")
        imagemExercicio.setImageResource(imagemRecebida as Int)

        botaoCronometro.setOnClickListener{
            btnIniciarCronometro.visibility = View.INVISIBLE;
            contador.visibility = View.VISIBLE
            ativarCronometro()
        }
    }

    fun ativarCronometro() {
        var cronometro = findViewById<TextView>(R.id.contador)

        object : CountDownTimer(60000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                var tempo = millisUntilFinished / 1000

                if(tempo < 10){
                    cronometro.setText("00:0${tempo}")
                }else{
                    cronometro.setText("00:${tempo}")
                }
            }
            override fun onFinish() {
                cronometro.setText("Feito!")
            }
        }.start()
    }

}
