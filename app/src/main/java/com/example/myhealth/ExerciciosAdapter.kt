package com.example.myhealth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myhealth.model.Exercicio



class ExerciciosAdapter(private val listaExercicios: MutableList<Exercicio>) :
    RecyclerView.Adapter<ExerciciosAdapter.ExercicioHolder>() {


    class ExercicioHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nomeExercicio: TextView = view.findViewById(R.id.txtExercicio)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExercicioHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_exercicio, parent, false)

        return ExercicioHolder(view)
    }

    override fun onBindViewHolder(holder: ExercicioHolder, position: Int) {
        //val item: TextView = findViewById(R.id.itemExercicio)

        holder.nomeExercicio.text = listaExercicios[position].nomeExercicio
        //holder.itemExercicio
    }

    override fun getItemCount(): Int {
        return listaExercicios.size
    }

}