package com.liucalvin.boggle.solver

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class TernarySearchTreeTest {

    private lateinit var tree: TernarySearchTree<Int>
    private val words = listOf(
            "HAT", "HAIR", "BAT", "BEAR", "BEARS", "BEERS", "TRAIN", "HELMET", "HELM", "TRADE", "HAPPY"
    )


    @Before
    fun setup() {
        tree = TernarySearchTree<Int>()
        words.shuffled()
        for (i in words.indices) {
            tree.put(words[i], i)
        }
    }

    @Test
    fun `verify TST adds and retrieves words properly`() {
        assertEquals(words.size, tree.size())
        for (element in words) {
            assertTrue(tree.contains(element))
        }
    }

    @Test
    fun `verify TST searches for prefix correctly`() {
        assertTrue(tree.containsPrefix("H"))
        assertTrue(tree.containsPrefix("HA"))
        assertTrue(tree.containsPrefix("HELME"))
        assertTrue(tree.containsPrefix("HAP"))
        assertTrue(tree.containsPrefix("BEA"))
        assertTrue(tree.containsPrefix("HELMET"))

        assertFalse(tree.containsPrefix("HI"))
        assertFalse(tree.containsPrefix("HAE"))
        assertFalse(tree.containsPrefix("TH"))
        assertFalse(tree.containsPrefix("HT"))
    }


    @Test
    fun `verify TST stores correct number of words`() {
        tree.clear()
        assertEquals(0, tree.size())

        for (i in 0..3) {
            tree.put(words[i], i)
        }
        assertEquals(4, tree.size())

        tree.clear()
        assertEquals(0, tree.size())

        for (i in 0..6) {
            tree.put(words[i], i)
        }
        assertEquals(7, tree.size())
    }




}