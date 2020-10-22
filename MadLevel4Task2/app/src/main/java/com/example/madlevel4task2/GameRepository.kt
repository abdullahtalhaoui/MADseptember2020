package com.example.madlevel4task2

import android.content.Context

class GameRepository(context: Context) {

    private val gameDao: GameDao

    init {
        val database = GameRoomDatabase.getDatabase(context)
        gameDao = database!!.gameDao()
    }

    suspend fun getAllStatistics(): List<Game> {
        return gameDao.getAllStatistics()
    }

    suspend fun insertStatistic(statistic: Game) {
        gameDao.insertStatistic(statistic)
    }

    suspend fun deleteAllStatistic() {
        gameDao.deleteAllStatistics()
    }

}
