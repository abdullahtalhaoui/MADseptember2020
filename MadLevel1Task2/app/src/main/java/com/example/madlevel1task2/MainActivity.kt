package com.example.madlevel1task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.madlevel1task2.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var correctAnswers: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }
    private fun initViews(){
        binding.btnSubmit.setOnClickListener { onCheckAnswer() }

    }
    private fun onCheckAnswer(){
        correctAnswers=0
        val answer1 =binding.etAnswer1.text.toString()
        val answer2 =binding.etAnswer2.text.toString()
        val answer3 =binding.etAnswer3.text.toString()
        val answer4 =binding.etAnswer4.text.toString()
        if (answer1=="T"){
            correctAnswers++
        }
        if (answer2=="F"){
            correctAnswers++
        }
        if (answer3=="F"){
            correctAnswers++
        }
        if (answer4=="F"){
            correctAnswers++
        }
        if(correctAnswers==4){
            Toast.makeText(this, getString(R.string.correct),Toast.LENGTH_LONG).show()
        }else{  Toast.makeText(this, getString(R.string.incorrect),Toast.LENGTH_LONG).show()}

    }

}