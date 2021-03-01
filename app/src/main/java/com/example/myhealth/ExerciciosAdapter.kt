package com.example.myhealth

import android.content.Intent
import android.content.UriMatcher
import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.RecyclerView
import com.example.myhealth.model.Exercicio



class ExerciciosAdapter(private val listaExercicios: MutableList<Exercicio>) :
    RecyclerView.Adapter<ExerciciosAdapter.ExercicioHolder>() {


    class ExercicioHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nomeExercicio: TextView = view.findViewById(R.id.txtExercicio)
        val fotoExercicio: ImageView = view.findViewById(R.id.imgExercicio)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExercicioHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_exercicio, parent, false)

        return ExercicioHolder(view)
    }

    override fun onBindViewHolder(holder: ExercicioHolder, position: Int) {
        holder.nomeExercicio.text = listaExercicios[position].nomeExercicio
        holder.fotoExercicio.setImageResource(listaExercicios[position].foto)

    }


    override fun getItemCount(): Int {
        return listaExercicios.size
    }

}