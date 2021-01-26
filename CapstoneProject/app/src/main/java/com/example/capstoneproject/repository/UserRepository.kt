package com.example.capstoneproject.repository

import android.content.Context
import androidx.annotation.DrawableRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.capstoneproject.R
import com.example.capstoneproject.dao.UserDao
import com.example.capstoneproject.database.UserRoomDatabase
import com.example.capstoneproject.model.User

class UserRepository(context: Context) {

    private var userDao: UserDao


    init {
        val userRoomDatabase =
            UserRoomDatabase.getDatabase(
                context
            )
        userDao = userRoomDatabase!!.userDao()
    }

    fun getUser(): LiveData<User> {
        return userDao.getUser() ?:
        MutableLiveData()
    }

    suspend fun insertUser(user: User) {
       userDao.insertUser(user)
    }

    suspend fun deleteUser(user: User) {
        userDao.deleteUser(user)
    }

    suspend fun updateUser(user: User) {
        userDao.updateUser(user)
    }


}
