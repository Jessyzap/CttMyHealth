package com.example.myhealth

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myhealth.model.Exercicio
import com.example.myhealth.model.Usuario
import kotlinx.android.synthetic.main.activity_lista_exercicios.*

class ListaExerciciosActivity : AppCompatActivity() {

    private lateinit var foto: ImageView
    private lateinit var nome: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_lista_exercicios)

        foto = findViewById(R.id.fotoFixa)
        nome = findViewById(R.id.nomeFixo)

        val nomeRecebido = intent.getStringExtra("NOME")
        nome.text = nomeRecebido

        val fotoRecebida = intent.getParcelableExtra<Bitmap>("IMAGEM")

        if (fotoRecebida is Bitmap) {
            foto.setImageBitmap(fotoRecebida)
        }

        val lista: MutableList<Exercicio> = mutableListOf(
            Exercicio(nomeExercicio = "Yoga", R.drawable.ic_005_yoga),
            Exercicio(nomeExercicio = "Bridge", R.drawable.ic_006_bridge),
            Exercicio(nomeExercicio = "Child", R.drawable.ic_010_child),
            Exercicio(nomeExercicio = "Leg", R.drawable.ic_031_leg),
            Exercicio(nomeExercicio = "Corpse", R.drawable.ic_012_corpse),
            Exercicio(nomeExercicio = "Lotus", R.drawable.ic_033_lotus),
            Exercicio(nomeExercicio = "Boat", R.drawable.ic_002_boat),
            Exercicio(nomeExercicio = "Camel", R.drawable.ic_007_camel),
            Exercicio(nomeExercicio = "Chair", R.drawable.ic_009_chair),
            Exercicio(nomeExercicio = "Cobra", R.drawable.ic_011_cobra)
        )

        val rvExercicios = findViewById<RecyclerView>(R.id.listaExercicios)
        rvExercicios.adapter = ExerciciosAdapter(lista)
        rvExercicios.layoutManager = LinearLayoutManager(this)
    }

}