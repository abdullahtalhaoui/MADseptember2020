package com.example.madlevel5task2

import android.os.Bundle
import android.view.Menu
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_add_game.*
import kotlinx.android.synthetic.main.fragment_add_game.etDay
import kotlinx.android.synthetic.main.fragment_add_game.etMonth
import kotlinx.android.synthetic.main.fragment_add_game.etPlatform
import kotlinx.android.synthetic.main.fragment_add_game.etTitle
import kotlinx.android.synthetic.main.fragment_add_game.etYear
import java.util.*

class AddActivity: AppCompatActivity() {
    private val viewModel:GameBacklogViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        fab2.setOnClickListener {
            saveGame()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_add, menu)
        return true
    }

    private fun saveGame() {
        val gameTitle = etTitle.text.toString()
        val gamePlatform = etPlatform.text.toString()
        val gameDay = etDay.text.toString().toInt()
        val gameMonth = etMonth.text.toString().toInt()
        val gameYear = etYear.text.toString().toInt()

        val date = Date(gameYear, gameMonth, gameDay)
        val game = GameBacklog(gameTitle, gamePlatform, date)

        viewModel.insertGameBacklog(game)
        finish()
    }
}