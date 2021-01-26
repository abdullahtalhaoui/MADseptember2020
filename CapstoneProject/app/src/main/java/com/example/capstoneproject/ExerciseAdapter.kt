package com.example.capstoneproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.capstoneproject.model.Exercise
import com.example.capstoneproject.repository.UserRepository
import kotlinx.android.synthetic.main.item_oefening.view.*

class ExerciseAdapter(private val exersices : List<Exercise>): RecyclerView.Adapter<ExerciseAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun databind(exercise: Exercise){
            itemView.tvTitelOefening.text = exercise.name
           itemView.ivOefening.setImageResource(exercise.imageResId )
            itemView.tvReps.text = exercise.reps
            itemView.tvSets.text = exercise.sets
            itemView.tvOpmerking.text = exercise.opmerking
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_oefening, parent,false)
        )
    }

    override fun getItemCount(): Int {
        return exersices.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.databind(exersices[position])
    }
}