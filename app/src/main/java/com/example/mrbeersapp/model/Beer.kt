package com.example.mrbeersapp.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "beer_table")
data class Beer(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val description: String
): Parcelable
