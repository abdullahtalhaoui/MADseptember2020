package com.example.madlevel4task1

import android.content.Context

class ProductRepository(context: Context) {

    private val productDao: ProductDao

    init {
        val database = ShoppingListRoomDatabase.getDatabase(context)
        productDao = database!!.productDao()
    }

    suspend fun getAllProducts(): List<ShoppingList> {
        return productDao.getAllProducts()
    }

    suspend fun insertProduct(product: ShoppingList) {
        productDao.insertProduct(product)
    }

    suspend fun deleteProduct(product: ShoppingList) {
        productDao.deleteProduct(product)
    }

    suspend fun deleteAllProducts() {
        productDao.deleteAllProducts()
    }

}
