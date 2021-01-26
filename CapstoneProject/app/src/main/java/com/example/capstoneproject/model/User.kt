package com.example.capstoneproject.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "UserTable")
data class User(
    @ColumnInfo(name= "surname")
    var surName: String? = "",
    @ColumnInfo(name= "lastname")
    var lastName: String? = "",
    @ColumnInfo(name= "age")
    var age : Int? = 0,
    @ColumnInfo(name= "weight")
    var weight: Int? = 0,
    @ColumnInfo(name= "amountexercises")
    var amountExercises: Int? = 0,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? =null
)