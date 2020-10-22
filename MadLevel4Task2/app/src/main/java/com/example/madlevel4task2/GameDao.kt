package com.example.madlevel4task2

import androidx.room.*

@Dao
interface GameDao {

    @Query("SELECT * FROM gameTable")
    suspend fun getAllStatistics(): List<Game>

    @Insert
    suspend fun insertStatistic(statistic: Game)

    @Query("DELETE FROM gameTable")
    suspend fun deleteAllStatistics()

}
