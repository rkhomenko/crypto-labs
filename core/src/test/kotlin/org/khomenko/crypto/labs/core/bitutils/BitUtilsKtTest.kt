package org.khomenko.crypto.labs.core.bitutils

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

@ExperimentalUnsignedTypes
internal class BitUtilsKtTest {
    private val radix = 2
    private val a = "1110101000".toUInt(radix)

    @Test
    fun multipleSwapBitsTest() {
        val expected = "101111".toUInt(radix)
        val result = swapBits(a, 0, 7, 3)
        assertEquals(expected, result)
    }

    @Test
    fun singleSwapBitsTest() {
        val expected = "1010101001".toUInt(radix)
        val result = swapBits(a, 0, 8)
        assertEquals(expected, result)
    }
}