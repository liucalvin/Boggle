package com.liucalvin.boggle.entity

import com.liucalvin.boggle.ui.gameplay.Tile
import kotlin.math.sqrt

fun Array<Array<Char>>.asTiles(): List<Tile> {
    val list = mutableListOf<Tile>()

    this.toList()
    var id = 0
    for (i in this.indices) {
        for (j in this[0].indices) {
            list.add(Tile(this[i][j], id++))
        }
    }
    return list
}

fun Array<Array<Char>>.asString(): String {
    val string = StringBuilder()

    for (i in this.indices) {
        for (j in this[0].indices) {
            string.append(this[i][j])
        }
    }
    return string.toString()
}

fun String.asBoardArrayOfChars(): Array<Array<Char>> {

    val n = sqrt(this.length.toDouble()).toInt()

    val boardArray: Array<Array<Char>> = Array(n) { Array(n) { ' ' } }

    var index = 0
    for (i in 0 until n) {
        for (j in 0 until n) {
            boardArray[i][j] = this[index++]
        }
    }
    return boardArray
}