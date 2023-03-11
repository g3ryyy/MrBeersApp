package com.example.mrbeersapp.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mrbeersapp.model.Beer

@Database(entities = [Beer::class], version = 1, exportSchema = false)
abstract class BeerDatabase : RoomDatabase() {

    abstract fun beerDao(): BeerDao

    companion object {
        @Volatile
        private var INSTANCE: BeerDatabase? = null


        fun getDatabase(context: Context): BeerDatabase {
            val tempInstanse = INSTANCE
            if (tempInstanse != null) {
                return tempInstanse
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BeerDatabase::class.java,
                    "beer_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}