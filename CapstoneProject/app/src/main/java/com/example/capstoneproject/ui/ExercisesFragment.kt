package com.example.capstoneproject.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.capstoneproject.ExerciseAdapter
import com.example.capstoneproject.R
import com.example.capstoneproject.model.Exercise
import kotlinx.android.synthetic.main.fragment_exercises.*

class ExercisesFragment : Fragment() {

    private val exercises = arrayListOf<Exercise>()
    private val exerciseAdapter = ExerciseAdapter(exercises)

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            return inflater.inflate(R.layout.fragment_exercises, container, false)
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }

    private fun initViews() {
        rvOefeningen.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        rvOefeningen.adapter =exerciseAdapter

        for (i in Exercise.EXCERCISE_NAME.indices) {
            exercises.add(Exercise(Exercise.EXCERCISE_NAME[i], Exercise.EXCERCISE_RES_DRAWABLE_IDS[i],
                Exercise.EXCERCISE_REPS[i], Exercise.EXCERCISE_SETS[i], Exercise.EXCERCISE_OPMERKING[i] ))

        }
        exerciseAdapter.notifyDataSetChanged()
    }




}