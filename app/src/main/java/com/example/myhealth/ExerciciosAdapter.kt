package com.example.myhealth

import android.content.Intent
import android.content.UriMatcher
import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.RecyclerView
import com.example.myhealth.model.Exercicio



class ExerciciosAdapter(private val listaExercicios: MutableList<Exercicio>) :
    RecyclerView.Adapter<ExerciciosAdapter.ExercicioHolder>() {


    class ExercicioHolder(view: View) : RecyclerView.ViewHolder(view){
        val nomeExercicio: TextView = view.findViewById(R.id.txtExercicio)
        val fotoExercicio: ImageView = view.findViewById(R.id.imgExercicio)

//        init{
//            view.setOnClickListener{
//            //    val position: Int = adapterPosition
//
//            val intent = Intent(view.context, ExercicioActivity::class.java)
//                view.context.startActivity(intent)
//                }
////                   Toast.makeText(view.context, "Clicado", Toast.LENGTH_SHORT).show()
//        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExercicioHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_exercicio, parent, false)

        return ExercicioHolder(view)
    }

    override fun onBindViewHolder(holder: ExercicioHolder, position: Int) {
        holder.nomeExercicio.text = listaExercicios[position].nomeExercicio
        holder.fotoExercicio.setImageResource(listaExercicios[position].foto)
        holder.itemView.setOnClickListener(){

//            Toast.makeText(it.context, "Deu certo", Toast.LENGTH_SHORT).show()
             val novaTela = Intent(it.context, ExercicioActivity::class.java)
             it.context.startActivity(novaTela)
        }
    }


    override fun getItemCount(): Int {
        return listaExercicios.size
    }

}