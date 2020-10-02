package org.khomenko.crypto.labs.core.bitutils

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.khomenko.crypto.labs.core.ext.toBinUInt

@ExperimentalUnsignedTypes
internal class BitUtilsKtTest {
    private val a: UInt = 0b1110101000u
    private val b: UInt = 0b11111000000000001000000000010101u

    @Test
    fun getBitTest() {
        assertEquals(getBit(b, 15), 1.toUByte())
    }

    @Test
    fun multipleSwapBitsTest() {
        val expected = 0b101111u
        val result = swapBits(a, 0, 7, 3)
        assertEquals(expected, result)
    }

    @Test
    fun singleSwapBitsTest() {
        val expected = 0b1010101001u
        val result = swapBits(a, 0, 8)
        assertEquals(expected, result)
    }

    @Test
    fun concatFirstLastBitsTest() {
        val expected = 0b1111110101u
        val result = concatFirstLastBits(b, 5)
        assertEquals(expected, result)
    }

    @Test
    fun extractBetweenFirstLastBits() {
        val expected = 0b10000000000u
        val result = extractBetweenFirstLastBits(b, 5)
        assertEquals(expected, result)
    }

    @Test
    fun xorAllBitsTest1() {
        val a = 0b101110001u
        assertEquals(xorAllBits(a), 1.toUByte())
    }

    @Test
    fun xorAllBitsTest2() {
        val a = 0b11100111u
        assertEquals(xorAllBits(a), 0.toUByte())
    }

    @Test
    fun circularLeftShiftTest() {
        val expected = 0b10000000000101011111100000000000u
        assertEquals(expected, b cshl 16)
    }

    @Test
    fun circularRightShiftTest() {
        val expected = 0b10000000000101011111100000000000u
        assertEquals(expected, b cshr 16)
    }
}