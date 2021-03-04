package com.liucalvin.boggle.ui.gameplay

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class GameViewModel : ViewModel() {

    private val _tilesList = MutableStateFlow<List<Tile>>(listOf())
    val tilesList: StateFlow<List<Tile>>
        get() = _tilesList

    init {
        val letters =
        for (i in 0..15) {

        }
        _tilesList.value = listOf(
            Tile
        )
    }

}