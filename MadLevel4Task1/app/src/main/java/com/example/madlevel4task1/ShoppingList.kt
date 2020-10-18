package com.example.madlevel4task1

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "productTable")
data class ShoppingList(
    @ColumnInfo(name= "productname")
    var productText: String,
    @ColumnInfo(name= "quantity")
    var amountQuantity: Short,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? =null
)