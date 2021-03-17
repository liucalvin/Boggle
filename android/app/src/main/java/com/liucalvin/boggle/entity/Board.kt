package com.liucalvin.boggle.entity

import androidx.room.Entity

// letter configurations taken from https://www.scribd.com/document/402786666/Boggle-docx

val default4x4 = arrayOf(
    arrayOf("AACIOT", "ABILTY", "ABJMOQ", "ACDEMP"),
    arrayOf("ACELRS", "ADENVZ", "AHMORS", "BIFORX"),
    arrayOf("DENOSW", "DKNOTU", "EEFHIY", "EGINTV"),
    arrayOf("EGKLUY", "EHINPS", "ELPSTU", "GILRUW")
)

val default5x5 = arrayOf(
    arrayOf("AAAFRS", "AAEEEE", "AAFIRS", "ADENNN", "AEEEEM"),
    arrayOf("AEEGMU", "AEGMNN", "AFIRSY", "BJKQXZ", "CCNSTW"),
    arrayOf("CEIILT", "CEILPT", "CEIPST", "DDLNOR", "DHHLOR"),
    arrayOf("DHHNOT", "DHLNOR", "EIIITT", "EMOTTT", "ENSSSU"),
    arrayOf("FIPRSY", "GORRVW", "HIPRRY", "NOOTUW", "OOOTTU")
)

class Board @JvmOverloads constructor(
    letters: Array<Array<String>> = default4x4,
    val randomizedLetters: Array<Array<Char>> = Array(letters.size) { Array(letters[0].size) { ' ' } }
) {

    val rows = letters.size
    val cols = letters[0].size  // assume uniform arrays

    init {
        for (i in 0 until rows) {
            require(letters[i].size == cols) { "Array is not uniformly rectangular" }
        }

        // randomize letters
        for (i in 0 until rows) {
            for (j in 0 until cols) {
                letters[i][j].apply {
                    randomizedLetters[i][j] = random()
                }
            }
        }
    }

    fun letterAt(i: Int, j: Int): Char {
        require((i >= 0 && j >= 0 && i < rows && j < cols)) { "Letter index out of bounds" }
        return randomizedLetters[i][j]
    }

}
