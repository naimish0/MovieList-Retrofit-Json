package com.example.retrofitexamplemovielist.Repository

import com.example.retrofitexamplemovielist.API.RetrofitServiceApi

class Repository(private val retrofitServiceApi: RetrofitServiceApi) {
    fun getAllMovies()=retrofitServiceApi.getAllMovies()
}

                 //Repository to handle tha data from API.
                 // passed retrofit service instance to perform network call