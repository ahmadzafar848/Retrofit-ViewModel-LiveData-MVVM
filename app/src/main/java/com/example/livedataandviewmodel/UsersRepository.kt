package com.example.livedataandviewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UsersRepository(private val apiService: ApiService,val context:Context) {
    private val data= MutableLiveData<ArrayList<UserModelItem>>()
    fun getUsers():LiveData<ArrayList<UserModelItem>>{


        apiService.getUsers().enqueue(object :Callback<ArrayList<UserModelItem>>{
            override fun onResponse(
                call: Call<ArrayList<UserModelItem>>,
                response: Response<ArrayList<UserModelItem>>
            ) {
                if (response.isSuccessful){
                    data.value=response.body()
                }
            }

            override fun onFailure(call: Call<ArrayList<UserModelItem>>, t: Throwable) {
            Toast.makeText(context,t.message.toString(),Toast.LENGTH_LONG).show()
            }
        })
        return data
    }
}