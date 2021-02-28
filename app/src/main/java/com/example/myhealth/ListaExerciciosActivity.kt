package com.example.myhealth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myhealth.model.Exercicio

class ListaExerciciosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_lista_exercicios)

        val lista: MutableList<Exercicio> = mutableListOf(
            Exercicio(nomeExercicio = "Yoga"),
            Exercicio(nomeExercicio = "Bridge"),
            Exercicio(nomeExercicio = "Child"),
            Exercicio(nomeExercicio = "Leg"),
            Exercicio(nomeExercicio = "Corpse"),
            Exercicio(nomeExercicio = "Lotus"),
            Exercicio(nomeExercicio = "Boat"),
            Exercicio(nomeExercicio = "Camel"),
            Exercicio(nomeExercicio = "Chair"),
            Exercicio(nomeExercicio = "Cobra")
        )

        val rvExercicios = findViewById<RecyclerView>(R.id.listaExercicios)
        rvExercicios.adapter = ExerciciosAdapter(lista)
        rvExercicios.layoutManager = LinearLayoutManager(this)
    }
}