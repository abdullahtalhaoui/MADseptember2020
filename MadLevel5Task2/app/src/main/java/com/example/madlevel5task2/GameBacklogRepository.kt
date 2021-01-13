package com.example.madlevel5task2

import android.content.Context
import androidx.lifecycle.LiveData

class GameBacklogRepository(context: Context) {

    private val gameBacklogDao: GameBacklogDao

    init {
        val database = GameBacklogRoomDatabase.getDatabase(context)
        gameBacklogDao = database!!.gameBacklogDao()
    }

    fun getAllGames(): LiveData<List<GameBacklog>> {
        return gameBacklogDao.getGameBacklog()
    }

    suspend fun deleteGame(gameBacklog: GameBacklog) {
        gameBacklogDao.deleteGame(gameBacklog)
    }

    suspend fun updateGameBacklog(gameBacklog: GameBacklog) {
        gameBacklogDao.updateGameBacklog(gameBacklog)
    }

    suspend fun insertGame(gameBacklog: GameBacklog) {
        gameBacklogDao.insertGame(gameBacklog)
    }

    suspend fun deleteGameBacklog() {
        gameBacklogDao.deleteAllGames()
    }

}