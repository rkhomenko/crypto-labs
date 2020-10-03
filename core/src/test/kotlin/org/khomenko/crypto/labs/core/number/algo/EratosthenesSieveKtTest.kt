package org.khomenko.crypto.labs.core.number.algo

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class EratosthenesSieveKtTest {
    @Test
    fun simpleTest() {
        assertEquals(listOf(2, 3), eratosthenesSieve(5))
    }

    @Test
    fun lessThanThirtyTest() {
        val expected = listOf(
                2, 3, 5, 7, 11, 13, 17, 19, 23, 29
        )
        assertEquals(expected, eratosthenesSieve(30))
    }

    @Test
    fun lessThanTwoHundredsTest() {
        val expected = listOf(
                2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43,
                47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103,
                107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163,
                167, 173, 179, 181, 191, 193, 197, 199
        )
        assertEquals(expected, eratosthenesSieve(200))
    }
}