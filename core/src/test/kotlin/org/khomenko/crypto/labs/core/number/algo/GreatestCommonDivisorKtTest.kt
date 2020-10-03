package org.khomenko.crypto.labs.core.number.algo

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GreatestCommonDivisorKtTest {
    @Test
    fun simpleTest() {
        assertEquals(6, greatestCommonDivisor(54, 24))
        assertEquals(4, greatestCommonDivisor(8, 12))
        assertEquals(6, greatestCommonDivisor(270,192))
    }
}