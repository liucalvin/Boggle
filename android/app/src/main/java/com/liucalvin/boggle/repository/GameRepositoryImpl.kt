package com.liucalvin.boggle.repository

import com.liucalvin.boggle.db.GameDatabase
import com.liucalvin.boggle.entity.BoggleGame
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first

class GameRepositoryImpl(private val gameDatabase: GameDatabase) : GameRepository {

    override suspend fun insertGame(boggleGame: BoggleGame) {
        gameDatabase.gameDao().insert(boggleGame)
    }

    override suspend fun getAllGames(): StateFlow<List<BoggleGame>> {
        return MutableStateFlow(gameDatabase.gameDao().getAllGames().first())
    }

}