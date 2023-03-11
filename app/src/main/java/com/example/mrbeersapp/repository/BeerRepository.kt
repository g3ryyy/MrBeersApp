package com.example.mrbeersapp.repository

import androidx.lifecycle.LiveData
import com.example.mrbeersapp.dao.BeerDao
import com.example.mrbeersapp.model.Beer

class BeerRepository(private val beerDao: BeerDao) {

    val readAllData: LiveData<List<Beer>> = beerDao.readAllData()

    suspend fun addBeer(beer: Beer){
        beerDao.addBeer(beer)
    }

    suspend fun updateBeer(beer: Beer){
        beerDao.updateBeer(beer)
    }

    suspend fun deleteBeer(beer: Beer){
        beerDao.deleteBeer(beer)
    }

    suspend fun deleteAllBeer(){
        beerDao.deleteAllBeer()
    }

}