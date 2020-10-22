package com.example.madlevel4task2

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "gameTable")
data class Game(
    @ColumnInfo(name= "date")
    var date: Long,
    @ColumnInfo(name= "computerHand")
    var computerHand: String,
    @ColumnInfo(name= "playerHand")
    var playerHand: String,
    @ColumnInfo(name= "winner")
    var winner: String,


    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? =null
)