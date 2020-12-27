package org.khomenko.crypto.labs.core.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.PI

@ExperimentalUnsignedTypes
class ContinuedFractionKtTest {
    @Test
    fun test075() {
        val alpha = 0.75
        val expected = listOf(
                0UL to 0.75,
                1UL to 0.333333,
                3UL to 0.0
        )
        val cf = ContinuedFraction(alpha)

        for ((e, r) in expected zip cf.iterator().asSequence().toList()) {
            Assertions.assertEquals(e.first, r.first)
            Assertions.assertEquals(e.second, r.second, cf.eps)
        }
    }

    @Test
    fun testPi() {
        val alpha = PI
        val expected = listOf(
                3, 7, 15, 1, 292, 1, 1, 1, 2, 1, 3, 1,
                14 // , 2, 1, 1, 2, 2, 2, 2, 1, 84, 2, 1, 1, 15, 3, 13
        )
        val cf = ContinuedFraction(alpha)

        val result = cf.iterator().asSequence()
                .map {
                    it.first.toInt()
                }
                .take(expected.size)
                .toList()

        Assertions.assertEquals(expected, result)
    }
}