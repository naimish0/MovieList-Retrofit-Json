package com.example.retrofitexamplemovielist.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitexamplemovielist.*
import com.example.retrofitexamplemovielist.API.RetrofitServiceApi
import com.example.retrofitexamplemovielist.Repository.Repository
import com.example.retrofitexamplemovielist.ViewModel.ViewModel
import com.example.retrofitexamplemovielist.ViewModel.ViewModelFactory
import com.example.retrofitexamplemovielist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val TAG="MainActivity"
    private lateinit var binding:ActivityMainBinding
    lateinit var viewModel: ViewModel

    private val retrofitService= RetrofitServiceApi.getInstance()
    val adapter= Adapter()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel=ViewModelProvider(this, ViewModelFactory(Repository(retrofitService))).get(
            ViewModel::class.java)

        binding.recycleView.adapter=adapter

        viewModel.moviesList.observe(this, Observer{
            Log.d(TAG,"onCreate:$it")
            adapter.setMoviesList(it)
        })
        viewModel.errorMessage.observe(this,Observer{
          Toast.makeText(applicationContext,"Check Your Internet",Toast.LENGTH_SHORT).show()
        })

        viewModel.getAllMovies()
    }
}