package com.example.madlevel5task2

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface GameBacklogDao {

    @Query("SELECT * FROM gamebacklogTable")
    fun getGameBacklog(): LiveData<List<GameBacklog>>

    @Insert
    suspend fun insertGame(gameBacklog: GameBacklog)

    @Update
    suspend fun updateGameBacklog(gameBacklog: GameBacklog)

    @Delete
    suspend fun deleteGame(gameBacklog: GameBacklog)

    @Query("DELETE FROM gamebacklogTable")
    suspend fun deleteAllGames()

}
