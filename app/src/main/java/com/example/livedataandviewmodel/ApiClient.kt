package com.example.livedataandviewmodel

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class ApiClient {
    private val BASE_URL: String = "https://jsonplaceholder.typicode.com/"
    private val retrofit =
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build()

    fun getApiService():ApiService{
        return retrofit.create(ApiService::class.java)
    }
}