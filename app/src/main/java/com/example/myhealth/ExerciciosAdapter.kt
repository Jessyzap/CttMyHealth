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
import com.example.myhealth.model.Usuario


class ExerciciosAdapter(private val listaExercicios: MutableList<Exercicio>) :
    RecyclerView.Adapter<ExerciciosAdapter.ExercicioHolder>() {


    class ExercicioHolder(view: View) : RecyclerView.ViewHolder(view){
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
        holder.itemView.setOnClickListener(){

//            Toast.makeText(it.context, "Posição $position", Toast.LENGTH_SHORT).show()
//             val novaTela = Intent(it.context, ExercicioActivity::class.java)
//             it.context.startActivity(novaTela)
            val destinoActivity = Intent(it.context, ExercicioActivity::class.java)
            destinoActivity.putExtra("EXERCICIO", listaExercicios[position].foto)
            destinoActivity.putExtra("NOME", listaExercicios[position].nomeExercicio)
            it.context.startActivity(destinoActivity)
            //it.context
        }
    }

//    fun redirecionar(exercicio: Exercicio, holder: ExercicioHolder) {
//
//
//
//    }

    override fun getItemCount(): Int {
        return listaExercicios.size
    }

}