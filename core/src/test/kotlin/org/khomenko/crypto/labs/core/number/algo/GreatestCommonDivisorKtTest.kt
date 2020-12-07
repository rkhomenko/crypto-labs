package org.khomenko.crypto.labs.core.number.algo

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

@ExperimentalUnsignedTypes
internal class GreatestCommonDivisorKtTest {
    @Test
    fun simpleTest() {
        assertEquals(6, greatestCommonDivisor(54L, 24L))
        assertEquals(4, greatestCommonDivisor(8L, 12L))
        assertEquals(6, greatestCommonDivisor(270L,192L))
    }
}