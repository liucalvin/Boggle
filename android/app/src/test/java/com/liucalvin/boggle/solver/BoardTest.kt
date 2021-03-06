package com.liucalvin.boggle.solver

import org.hamcrest.CoreMatchers
import org.hamcrest.Matchers.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class BoardTest {

    private lateinit var subject: Board

    @get: Rule
    val exception: ExpectedException = ExpectedException.none()

    @Before
    fun setup() {
        subject = Board(
            arrayOf(
                arrayOf("A", "B", "C", "D"),
                arrayOf("E", "F", "G", "H"),
                arrayOf("I", "J", "K", "L"),
                arrayOf("M", "N", "O", "P")
            )
        )
    }

    @Test
    fun `verify board returns correct letter at position`() {
        assertEquals('A', subject.letterAt(0, 0))
        assertEquals('J', subject.letterAt(2, 1))
        assertEquals('D', subject.letterAt(0, 3))
        assertEquals('P', subject.letterAt(3, 3))
    }

    @Test
    fun `verify board throws exception when i position is out of range`() {
        exception.expect(IllegalArgumentException::class.java)
        exception.expectMessage("Letter index out of bounds")

        subject.letterAt(4, 0)
    }

    @Test
    fun `verify board throws exception when j position is out of range`() {
        exception.expect(IllegalArgumentException::class.java)
        exception.expectMessage("Letter index out of bounds")

        subject.letterAt(0, 4)
    }

    @Test
    fun `verify board throws exception when i position is negative`() {
        exception.expect(IllegalArgumentException::class.java)
        exception.expectMessage("Letter index out of bounds")

        subject.letterAt(-1, 2)
    }

    @Test
    fun `verify board throws exception when j position is negative`() {
        exception.expect(IllegalArgumentException::class.java)
        exception.expectMessage("Letter index out of bounds")

        subject.letterAt(2, -1)
    }

    @Test
    fun `verify exception thrown when board is not uniformly rectangular`() {
        exception.expect(IllegalArgumentException::class.java)
        exception.expectMessage("Array is not uniformly rectangular")

        subject = Board(
            arrayOf(
                arrayOf("A", "B", "C", "D"),
                arrayOf("E", "F", "G"),
                arrayOf("H", "I", "J", "K", "L"),
                arrayOf("M", "N")
            )
        )
    }

    @Test
    fun `verify letterAt gets random letters from input board`() {
        subject = Board(arrayOf(
            arrayOf("ABC", "DEF", "GHI"),
            arrayOf("JKL", "MNO", "PQR"),
            arrayOf("STU", "VWX", "YZ")
        ))

        assertThat(subject.letterAt(0,0), `is`(oneOf('A', 'B', 'C')))
        assertThat(subject.letterAt(1,0), `is`(oneOf('J', 'K', 'L')))
        assertThat(subject.letterAt(2,0), `is`(oneOf('S', 'T', 'U')))
        assertThat(subject.letterAt(1,2), `is`(oneOf('P', 'Q', 'R')))
    }

}