package com.example.capstoneproject.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.capstoneproject.model.User

@Dao
interface UserDao {
    @Query("SELECT * FROM userTable")
    fun getUser(): LiveData<User>
    @Insert
    suspend fun insertUser(user: User)
    @Delete
    suspend fun deleteUser(user: User)
    @Update
    suspend fun updateUser(user: User)
}