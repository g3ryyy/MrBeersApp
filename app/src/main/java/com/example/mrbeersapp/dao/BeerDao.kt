package com.example.mrbeersapp.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mrbeersapp.model.Beer

@Dao
interface BeerDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addBeer(beer: Beer)

    @Update
    suspend fun updateBeer(beer: Beer)

    @Delete
    suspend fun deleteBeer(beer: Beer)

    @Query("DELETE FROM beer_table")
    suspend fun deleteAllBeer()


    @Query("SELECT * FROM beer_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Beer>>

}