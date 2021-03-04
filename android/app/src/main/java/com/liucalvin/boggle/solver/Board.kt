package com.liucalvin.boggle.solver

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

class Board(private val letters: Array<Array<String>> = default4x4) {

    val rows = letters.size
    val cols = letters[0].size  // assume uniform arrays

    private lateinit var randomizedLetters: Array<Array<Char>>

    init {
        for (i in 0 until rows) {
            require(letters[i].size == cols) { "Array is not uniformly rectangular" }
        }

        // randomize letters

    }

    fun letterAt(i: Int, j: Int): Char {
        require((i >= 0 && j >= 0 && i < rows && j < cols)) { "Letter index out of bounds" }
        return randomizedLetters[i][j]
    }

}
