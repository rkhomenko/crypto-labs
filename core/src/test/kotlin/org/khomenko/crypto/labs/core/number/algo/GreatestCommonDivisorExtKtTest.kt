package org.khomenko.crypto.labs.core.number.algo

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@ExperimentalUnsignedTypes
internal class GreatestCommonDivisorExtKtTest {
    @Test
    fun simpleTest() {
        val triples = listOf(
                Triple(54L, 24L, 6L),
                Triple(8L, 12L, 4L),
                Triple(270L, 192L, 6L)
        )

        for ((a, b, rExpected) in triples) {
            val (r, x, y) = greatestCommonDivisorExt(a, b)
            Assertions.assertEquals(rExpected, r)
            Assertions.assertEquals(rExpected, x * a + y * b)
        }
    }
}