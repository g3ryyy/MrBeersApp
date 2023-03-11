package com.example.mrbeersapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.mrbeersapp.dao.BeerDatabase
import com.example.mrbeersapp.model.Beer
import com.example.mrbeersapp.repository.BeerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BeerViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<Beer>>
    private val repository: BeerRepository

    init {
        val beerDao = BeerDatabase.getDatabase(application).beerDao()
        repository = BeerRepository(beerDao)
        readAllData = repository.readAllData
    }

    fun addBeer(beer: Beer) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addBeer(beer)
        }
    }

    fun updateBeer(beer: Beer) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateBeer(beer)
        }
    }

    fun deleteBeer(beer: Beer) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteBeer(beer)
        }
    }

    fun deleteAllBeer() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllBeer()
        }
    }

    /* fun searchQuery(searchQuery: String): LiveData<List<Chips>>{
         return repository.searchDatabase(searchQuery).asFlow()
     }*/
}