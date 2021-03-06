package com.liucalvin.boggle.ui.gameplay

import androidx.lifecycle.ViewModel
import com.liucalvin.boggle.db.asTiles
import com.liucalvin.boggle.solver.Board
import com.liucalvin.boggle.solver.default5x5
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.math.sqrt

class GameViewModel : ViewModel() {

    private val _tilesList = MutableStateFlow<List<Tile>>(listOf())
    val tilesList: StateFlow<List<Tile>>
        get() = _tilesList

    private val _boardSize = MutableStateFlow(1)
    val boardSize: StateFlow<Int>
        get() = _boardSize

    init {
        _tilesList.value = Board().randomizedLetters.asTiles()
        _boardSize.value = sqrt(_tilesList.value.size.toDouble()).toInt()
    }

    fun onTileTouched(id: Int) {
        TODO("Not yet implemented")
    }

}