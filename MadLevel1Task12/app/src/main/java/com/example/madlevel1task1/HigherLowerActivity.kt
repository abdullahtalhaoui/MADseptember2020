package com.example.madlevel1task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.madlevel1task1.databinding.ActivityHigherLowerBinding

class HigherLowerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHigherLowerBinding
    private var currentThrow: Int = 1
    private var lastThrow: Int = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHigherLowerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews(){
        binding.btnEquals.setOnClickListener{onEqualsclick()}
        binding.btnLower.setOnClickListener {onLowerclick() }
        binding.btnHigher.setOnClickListener {onHigherclick()}
        updateUI()

    }
    private fun updateUI() {
        binding.tvLastThrow.text = getString(R.string.last_throw, lastThrow)

        when (currentThrow) {
            1 -> binding.ivDice.setImageResource(R.drawable.dice1)
            2 -> binding.ivDice.setImageResource(R.drawable.dice2)
            3 -> binding.ivDice.setImageResource(R.drawable.dice3)
            4 -> binding.ivDice.setImageResource(R.drawable.dice4)
            5 -> binding.ivDice.setImageResource(R.drawable.dice5)
            6 -> binding.ivDice.setImageResource(R.drawable.dice6)
        }
    }
    private fun rollDice(){
        lastThrow = currentThrow
        currentThrow=(1..6).random()
        updateUI()
    }
    private  fun onEqualsclick(){
        rollDice()

        if(currentThrow== lastThrow)onAnswercorrect()
        else onAnswerIncorrect()
    }
    private fun onLowerclick(){
        rollDice()

        if (currentThrow<lastThrow)onAnswercorrect()
        else onAnswerIncorrect()
    }
    private fun onHigherclick(){
        rollDice()

        if (currentThrow>lastThrow)onAnswercorrect()
        else onAnswerIncorrect()
    }
    private fun onAnswercorrect(){
        Toast.makeText(this, getString(R.string.correct), Toast.LENGTH_SHORT).show()
    }
    private fun onAnswerIncorrect(){
        Toast.makeText(this, getString(R.string.incorrect), Toast.LENGTH_SHORT).show()
    }
}