package com.example.retrofitexamplemovielist.API

import com.example.retrofitexamplemovielist.Model.Model
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitServiceApi {
    @GET("movielist.json")
    fun getAllMovies():Call<List<Model>>           //Interface for Api call definition

    companion object{

        var retrofitServiceApi: RetrofitServiceApi?=null

        fun getInstance(): RetrofitServiceApi {
            if(retrofitServiceApi ==null)
            {                                                //Creating Instance of RetrofitService
                val retrofit=Retrofit.Builder()
                    .baseUrl("https://howtodoandroid.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitServiceApi =retrofit.create(RetrofitServiceApi::class.java)
            }
            return retrofitServiceApi!!
        }
    }
}