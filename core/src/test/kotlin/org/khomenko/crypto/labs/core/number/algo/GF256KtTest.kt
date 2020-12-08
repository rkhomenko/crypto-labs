package org.khomenko.crypto.labs.core.number.algo

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.abs

@ExperimentalUnsignedTypes
class GF256KtTest {
    val aBits: UByte = 0b01010011u // 0x53
    val bBits: UByte = 0b11001010u // 0xCA

    @Test
    fun additionTest() {
        val gf256 = GF256.getInstance(GF256.AES)
        val a = gf256.getElement(aBits)
        val b = gf256.getElement(bBits)
        val c1 = a + b
        val c2 = b + a

        Assertions.assertEquals(aBits xor bBits, c1.a)
        Assertions.assertEquals(aBits xor bBits, c2.a)
    }

    @Test
    fun multiplicationTest() {
        val gf256 = GF256.getInstance(GF256.AES)
        val a = gf256.getElement(aBits)
        val b = gf256.getElement(bBits)
        val c1 = a * b
        val c2 = b * a
        val expected: UByte = 0x1U

        Assertions.assertEquals(expected, c1.a)
        Assertions.assertEquals(expected, c2.a)
    }
}