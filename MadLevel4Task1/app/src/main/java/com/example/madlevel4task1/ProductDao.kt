package com.example.madlevel4task1

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProductDao {

    @Query("SELECT * FROM productTable")
    suspend fun getAllProducts(): List<ShoppingList>

    @Insert
    suspend fun insertProduct(product: ShoppingList)

    @Delete
    suspend fun deleteProduct(product: ShoppingList)

    @Query("DELETE FROM productTable")
    suspend fun deleteAllProducts()

}
