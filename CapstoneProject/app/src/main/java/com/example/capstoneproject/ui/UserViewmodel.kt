package com.example.capstoneproject.ui

import android.app.Application
import android.text.Editable
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.capstoneproject.model.User
import com.example.capstoneproject.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserViewmodel(application: Application) : AndroidViewModel(application) {
    private val ioScope = CoroutineScope(Dispatchers.IO)
    private val userRepository = UserRepository(application.applicationContext)
    private val mainScope = CoroutineScope(Dispatchers.Main)
    val user: LiveData<User> = userRepository.getUser()
    val error = MutableLiveData<String>()
    val success = MutableLiveData<Boolean>()


    fun updateUser(user: User) {
        ioScope.launch {
            userRepository.updateUser(user)
        }
    }

    fun insertUser(user: User) {
        ioScope.launch {
            userRepository.insertUser(user)
        }
    }


    fun deleteUser(user: User) {
        ioScope.launch {
            userRepository.deleteUser(user)
        }
    }

}