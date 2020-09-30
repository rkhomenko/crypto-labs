package org.khomenko.crypto.labs.core.bitutils

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.khomenko.crypto.labs.core.ext.toBinUInt

@ExperimentalUnsignedTypes
internal class BitUtilsKtTest {
    private val a = "1110101000".toBinUInt()
    private val b = "11111000000000001000000000010101".toBinUInt()

    @Test
    fun getBitTest() {
        assertEquals(getBit(b, 15), 1.toUByte())
    }

    @Test
    fun multipleSwapBitsTest() {
        val expected = "101111".toBinUInt()
        val result = swapBits(a, 0, 7, 3)
        assertEquals(expected, result)
    }

    @Test
    fun singleSwapBitsTest() {
        val expected = "1010101001".toBinUInt()
        val result = swapBits(a, 0, 8)
        assertEquals(expected, result)
    }

    @Test
    fun concatFirstLastBitsTest() {
        val expected = "1111110101".toBinUInt()
        val result = concatFirstLastBits(b, 5)
        assertEquals(expected, result)
    }

    @Test
    fun extractBetweenFirstLastBits() {
        val expected = "10000000000".toBinUInt()
        val result = extractBetweenFirstLastBits(b, 5)
        assertEquals(expected, result)
    }

    @Test
    fun xorAllBitsTest1() {
        val a = "101110001".toBinUInt()
        assertEquals(xorAllBits(a), 1.toUByte())
    }

    @Test
    fun xorAllBitsTest2() {
        val a = "11100111".toBinUInt()
        assertEquals(xorAllBits(a), 0.toUByte())
    }
}