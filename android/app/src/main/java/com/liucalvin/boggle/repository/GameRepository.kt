package com.liucalvin.boggle.repository

import com.liucalvin.boggle.entity.BoggleGame
import kotlinx.coroutines.flow.StateFlow

interface GameRepository {

    suspend fun insertGame(boggleGame: BoggleGame)

    suspend fun getAllGames(): StateFlow<List<BoggleGame>>

}