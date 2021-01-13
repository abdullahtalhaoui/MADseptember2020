package com.example.madlevel5task2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBar
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.fragment_game_backlog.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private val viewModel: GameBacklogViewModel by viewModels()
    private val gameBacklogs = arrayListOf<GameBacklog>()
    private val gameBacklogAdapter = GameBacklogAdapter(gameBacklogs)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        observeAddGameResult()
    }

    private fun initViews() {
        fab.setOnClickListener {
            startActivity(Intent(this@MainActivity, AddActivity::class.java))
            true
        }
        rvGames.layoutManager = LinearLayoutManager(
            this@MainActivity,
            RecyclerView.VERTICAL,
            false
        )
        rvGames.adapter = gameBacklogAdapter

        createItemTouchHelper().attachToRecyclerView(rvGames)
    }

    private fun observeAddGameResult() {
        viewModel.gameBacklogs.observe(this@MainActivity, Observer { gameBacklogs ->
            this@MainActivity.gameBacklogs.clear()
            this@MainActivity.gameBacklogs.addAll(gameBacklogs)
            this@MainActivity.gameBacklogs.sortWith(compareBy { it.releaseDate })
            gameBacklogAdapter.notifyDataSetChanged()
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.btn_delete_history ->{
            viewModel.deleteAllGameBacklog()
            true
            }else -> super.onOptionsItemSelected(item)
        }
    }
    private fun createItemTouchHelper(): ItemTouchHelper {

        // Callback which is used to create the ItemTouch helper. Only enables left swipe.
        // Use ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) to also enable right swipe.
        val callback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {

            // Enables or Disables the ability to move items up and down.
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            // Callback triggered when a user swiped an item.
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition

                val gameBacklogDelete= gameBacklogs[position]
                viewModel.deleteGameBacklog(gameBacklogDelete)
                gameBacklogAdapter.notifyDataSetChanged()
            }
        }
        return ItemTouchHelper(callback)
    }


}