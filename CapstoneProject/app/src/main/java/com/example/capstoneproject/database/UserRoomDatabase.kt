package com.example.capstoneproject.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.capstoneproject.dao.UserDao
import com.example.capstoneproject.model.User


@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserRoomDatabase: RoomDatabase() {

    abstract fun userDao(): UserDao
    companion object {
        private const val DATABASE_NAME = "USER_DATABASE"

        @Volatile
        private var userRoomDatabaseInstance: UserRoomDatabase? = null

        fun getDatabase(context: Context): UserRoomDatabase? {
            if (userRoomDatabaseInstance == null) {
                synchronized(UserRoomDatabase::class.java) {
                    if (userRoomDatabaseInstance == null) {
                        userRoomDatabaseInstance = Room.databaseBuilder(
                            context.applicationContext,
                            UserRoomDatabase::class.java,
                            DATABASE_NAME
                        )
                            .build()
                    }
                }
            }
            return userRoomDatabaseInstance
        }
    }

}
