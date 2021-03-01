package com.liucalvin.boggle.solver

class Board(private val letters: Array<CharArray>) {

    val rows = letters.size
    val cols = letters[0].size  // assume uniform arrays

    init {
        for (i in 0 until rows) {
            require(letters[i].size == cols) { "Array is not uniformly rectangular" }
        }
    }

    fun letterAt(i: Int, j: Int): Char {
        require((i >= 0 && j >= 0 && i < rows && j < cols)) { "Letter index out of bounds" }
        return letters[i][j]
    }
}