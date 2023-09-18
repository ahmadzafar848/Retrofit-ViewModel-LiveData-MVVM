package com.example.livedataandviewmodel

import UserViewModelFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.livedataandviewmodel.databinding.ActivityMainBinding
import com.google.android.material.progressindicator.CircularProgressIndicator

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var userViewModel: UserViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var circularBar:CircularProgressIndicator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        circularBar=binding.mainpb
        setContentView(binding.root)

        recyclerView = binding.rvUsers
        recyclerView.layoutManager = LinearLayoutManager(this)

        val usersRepository = UsersRepository(ApiClient().getApiService(), this)
        val viewModelFactory = UserViewModelFactory(usersRepository)

        userViewModel = ViewModelProvider(this, viewModelFactory)[UserViewModel::class.java]

        observeUserList()
    }

    private fun observeUserList() {

       circularBar.visibility=View.VISIBLE
        userViewModel.getUsers().observe(this, Observer {
            circularBar.visibility=View.INVISIBLE
            recyclerView.adapter = UserAdapter(it)
        })
    }
}
