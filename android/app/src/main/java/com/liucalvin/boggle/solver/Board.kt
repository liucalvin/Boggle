package com.liucalvin.boggle.solver

class Board(private val letters: Array<CharArray>) {
    var rows = 0
    var cols = 0
    fun letterAt(i: Int, j: Int): Char {
        require(!(i < 0 || j < 0 || i > rows || j > cols)) { "Index out of bounds" }
        return letters[i][j]
    }
}