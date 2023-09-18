package com.example.livedataandviewmodel

import androidx.lifecycle.LiveData
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.Response

interface ApiService {
@GET("/users")
fun getUsers():Call<ArrayList<UserModelItem>>
}