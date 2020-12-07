package org.khomenko.crypto.labs.core.number.algo

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

@ExperimentalUnsignedTypes
class FermatPrimalityKtTest {
    companion object Init {
        var primes: LongArray? = null
        var nonPrimes: LongArray? = null

        @BeforeAll
        @JvmStatic
        fun init() {
            primes = this::class.java.classLoader.getResourceAsStream("./primes.csv")
                    .bufferedReader()
                    .readLines()
                    .map { it.toLong() }
                    .toLongArray()

            nonPrimes = LongRange(1L, 1000000L)
                    .filter { primes!!.binarySearch(it) < 0 }
                    .toLongArray()
        }
    }

    @Test
    fun primesTest() {
        primes?.forEach { Assertions.assertTrue(fermatPrimalityTest(it)) }
    }

    @Test
    fun nonPrimeTest() {
        nonPrimes?.forEach { Assertions.assertFalse(fermatPrimalityTest(it)) }
    }
}