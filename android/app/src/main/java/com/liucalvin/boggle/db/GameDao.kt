package com.liucalvin.boggle.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.liucalvin.boggle.entity.BoggleGame
import kotlinx.coroutines.flow.Flow

@Dao
interface GameDao {

    @Insert
    fun insert(vararg game: BoggleGame)

    @Delete
    fun delete(game: BoggleGame)

    @Query ("SELECT * FROM games ORDER BY date DESC")
    fun getAllGames(): Flow<List<BoggleGame>>

}