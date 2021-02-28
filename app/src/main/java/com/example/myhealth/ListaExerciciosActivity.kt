package com.example.myhealth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myhealth.model.Exercicio


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

        //val fotoRecebida = intent.extras?.get("IMAGEM") as Bitmap
        //foto.setImageBitmap(fotoRecebida)


//        val usuario = intent.extras?.get("USUARIO") as Usuario
//
//        usuario.foto?.let{
//            imgUsuario.setImageBitmap(it)
//        }
//
//        nome.text = usuario.nome


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