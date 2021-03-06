package com.liucalvin.boggle.db

import com.liucalvin.boggle.ui.gameplay.Tile

fun Array<Array<Char>>.asTiles() : List<Tile> {
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