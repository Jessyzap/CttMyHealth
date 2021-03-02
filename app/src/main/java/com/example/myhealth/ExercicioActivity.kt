package com.example.myhealth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.SystemClock
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_yoga.*
import kotlin.time.milliseconds

class ExercicioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yoga)

        var cronometro = findViewById<TextView>(R.id.contador)

        object : CountDownTimer(20000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                var tempo = millisUntilFinished / 1000

                if(tempo < 10){
                    cronometro.setText("00:0${tempo}")
                }else{
                    cronometro.setText("00:${tempo}")
                }
            }

            override fun onFinish() {
                cronometro.setText("done!")
            }
        }.start()
    }
}
// BOM DIA  