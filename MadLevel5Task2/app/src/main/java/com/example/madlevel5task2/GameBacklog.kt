package com.example.madlevel5task2

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "gamebacklogTable")
data class GameBacklog(
    @ColumnInfo(name="title")
    var title: String,
    @ColumnInfo(name="platform")
    var platform: String,
    @ColumnInfo(name="releaseDate")
    var releaseDate: Date,


    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? =null
)