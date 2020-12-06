package org.khomenko.crypto.labs.core.number.algo

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class GreatestCommonDivisorExtKtTest {
    @Test
    fun simpleTest() {
        val triples = listOf(
                Triple(54, 24, 6),
                Triple(8, 12, 4),
                Triple(270, 192, 6)
        )

        for ((a, b, rExpected) in triples) {
            val (r, x, y) = greatestCommonDivisorExt(a, b)
            Assertions.assertEquals(rExpected, r)
            Assertions.assertEquals(rExpected, x * a + y * b)
        }
    }
}