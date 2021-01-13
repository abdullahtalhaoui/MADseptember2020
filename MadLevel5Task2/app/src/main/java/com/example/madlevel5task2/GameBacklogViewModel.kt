package com.example.madlevel5task2

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class GameBacklogViewModel(application: Application) : AndroidViewModel(application) {

    private val ioScope = CoroutineScope(Dispatchers.IO)
    private val gameBacklogRepository = GameBacklogRepository(application.applicationContext)

    val gameBacklogs : LiveData<List<GameBacklog>> = gameBacklogRepository.getAllGames()


    fun insertGameBacklog(gameBacklog: GameBacklog) {
        ioScope.launch {
            gameBacklogRepository.insertGame(gameBacklog)
        }
    }

    fun deleteGameBacklog(gameBacklog: GameBacklog) {
        ioScope.launch {
            gameBacklogRepository.deleteGame(gameBacklog)
        }
    }
    fun deleteAllGameBacklog() {
        ioScope.launch {
            gameBacklogRepository.deleteGameBacklog()
        }
    }


}
