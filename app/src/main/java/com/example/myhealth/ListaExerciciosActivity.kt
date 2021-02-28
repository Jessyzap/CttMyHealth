package com.example.myhealth

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myhealth.model.Exercicio
import com.example.myhealth.model.Usuario
import kotlinx.android.synthetic.main.activity_cadastro.*


class ListaExerciciosActivity : AppCompatActivity() {

//    private lateinit var foto: ImageView
//    private lateinit var nome: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_lista_exercicios)


//        val usuario = intent.extras?.get("USUARIO") as Usuario
//
//
////        usuario.foto?.let{
////            imgUsuario.setImageBitmap(it)
////        }
//
//
//        foto = findViewById(R.id.fotoFixa)
//        nome = findViewById(R.id.nomeFixo)
//
//        //nome.text = usuario.nome


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