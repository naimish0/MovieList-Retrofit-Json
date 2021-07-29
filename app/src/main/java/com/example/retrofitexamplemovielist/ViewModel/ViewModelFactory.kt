package com.example.retrofitexamplemovielist.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitexamplemovielist.Repository.Repository

class ViewModelFactory(private val repository: Repository):ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(ViewModel::class.java))
        {
            ViewModel(repository) as T
        }
        else{
            throw IllegalArgumentException("ViewModel not Found")
        }
    }                      //For Creating instance of ViewModel

}