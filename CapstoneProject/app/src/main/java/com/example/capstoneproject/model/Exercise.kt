package com.example.capstoneproject.model

import androidx.annotation.DrawableRes
import com.example.capstoneproject.R

data class Exercise (
var name: String,
@DrawableRes var imageResId: Int = 0,
var reps: String,
var sets: String,
var opmerking: String)
{

    companion object {
        val EXCERCISE_NAME = arrayOf(
            "Squats",
            "Wall sit",
            "Lunge",
            "Call jumps"
        )

        val EXCERCISE_RES_DRAWABLE_IDS = arrayOf(
            R.drawable.squat,
            R.drawable.wallsit,
            R.drawable.lunge,
            R.drawable.calljumps

        )
        val EXCERCISE_REPS = arrayOf(
            "10 reps",
            "90 sec",
            "5 reps x2",
            "15 reps"
        )
        val EXCERCISE_SETS = arrayOf(
            "3 sets",
            "3 sets",
            "4 sets",
            "3 sets"
        )
        val EXCERCISE_OPMERKING = arrayOf(
            "belangrijk: rug recht",
            "belangrijk: Behoud positie",
            "belangrijk: rug recht",
            "belangrijk: Spanning"
        )
    }
}