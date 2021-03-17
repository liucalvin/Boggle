package com.liucalvin.boggle.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "games")
data class BoggleGame(
    val board: String,
    var points: Int,
    @PrimaryKey
    val date: String
)