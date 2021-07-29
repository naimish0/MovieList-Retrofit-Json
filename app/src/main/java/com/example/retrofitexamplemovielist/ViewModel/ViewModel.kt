package com.example.retrofitexamplemovielist.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitexamplemovielist.Model.Model
import com.example.retrofitexamplemovielist.Repository.Repository
import retrofit2.Call
import retrofit2.Response

class ViewModel(val repository: Repository) :ViewModel() {
    val moviesList=MutableLiveData<List<Model>>()
    val errorMessage=MutableLiveData<String>()


    fun getAllMovies()
    {
        val response=repository.getAllMovies()
        response.enqueue(object :retrofit2.Callback<List<Model>>
        {
            override fun onResponse(call:Call<List<Model>>, response: Response<List<Model>>){
                moviesList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Model>>, t:Throwable)
            {
                errorMessage.postValue(t.message)
            }
        })                        //For BusinessLogic Api call Implementation
    }
}