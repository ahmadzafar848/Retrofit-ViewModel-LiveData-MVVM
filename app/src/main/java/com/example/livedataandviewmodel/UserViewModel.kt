package com.example.livedataandviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class UserViewModel(private val usersRepository: UsersRepository) : ViewModel() {
    fun getUsers(): LiveData<ArrayList<UserModelItem>> {
        return usersRepository.getUsers()
    }
}