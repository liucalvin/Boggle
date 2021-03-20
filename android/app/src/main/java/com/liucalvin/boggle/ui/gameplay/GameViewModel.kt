package com.liucalvin.boggle.ui.gameplay

import androidx.lifecycle.ViewModel
import com.liucalvin.boggle.entity.asTiles
import com.liucalvin.boggle.entity.Board
import com.liucalvin.boggle.repository.GameRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.math.sqrt

class GameViewModel(private val repository: GameRepository) : ViewModel() {

    private val _tilesList = MutableStateFlow<List<Tile>>(listOf())
    val tilesList: StateFlow<List<Tile>>
        get() = _tilesList

    private val _boardSize = MutableStateFlow(1)
    val boardSize: StateFlow<Int>
        get() = _boardSize

    private val _currentScore = MutableStateFlow(0)
    val currentScore: StateFlow<Int>
        get() = _boardSize

    private val _correctWords = MutableStateFlow<MutableList<String>>(mutableListOf())
    val correctWords: StateFlow<List<String>>
        get() = _correctWords

    init {
        _tilesList.value = Board().randomizedLetters.asTiles()
        _boardSize.value = sqrt(_tilesList.value.size.toDouble()).toInt()
        _correctWords.value = mutableListOf("")
    }

    fun onTileTouched(id: Int) {
        _correctWords.value[0] = _correctWords.value[0] + "$id "
    }

}