package com.example.madlevel4task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_game_history.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class GameHistoryActivity : AppCompatActivity() {
    private lateinit var gameRepository: GameRepository
    private val mainScope = CoroutineScope(Dispatchers.Main)
    private val statistics = arrayListOf<Game>()
    private val gameAdapter = GameAdapter(statistics)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_history)

        gameRepository = GameRepository(this@GameHistoryActivity)
        getStatisticsFromDatabase()

        initRv()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_game_history, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.btn_delete_history ->{
                deleteStatistics()
                true}
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun initRv() {
        val viewManager = LinearLayoutManager(this@GameHistoryActivity)
        rvHistory.addItemDecoration(
            DividerItemDecoration(
                this@GameHistoryActivity,
                DividerItemDecoration.VERTICAL
            )
        )

        rvHistory.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = gameAdapter
        }
    }

    private fun deleteStatistics() {
        mainScope.launch {
            withContext(Dispatchers.IO){
                gameRepository.deleteAllStatistic()
            }
            getStatisticsFromDatabase()
        }
    }

    private fun getStatisticsFromDatabase() {
        mainScope.launch {
            val games = gameRepository.getAllStatistics()
            this@GameHistoryActivity.statistics.clear()
            this@GameHistoryActivity.statistics.addAll(games)
            gameAdapter.notifyDataSetChanged()
        }
    }
}