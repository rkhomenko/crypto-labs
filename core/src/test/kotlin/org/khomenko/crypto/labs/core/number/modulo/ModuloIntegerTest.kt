package org.khomenko.crypto.labs.core.number.modulo

import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ModuloIntegerTest {
    @Test
    fun creationTest() {
        val a = ModuloInteger.of(5, 10)
        val b = ModuloInteger.of(7, 5)
        assertAll(
                { assertEquals(5, a.value) },
                { assertEquals(10, a.n) },
                { assertEquals(2, b.value) }
        )
    }

    @Test
    fun additionTest() {
        val a = ModuloInteger.of(3, 5)
        val b = ModuloInteger.of(4, 5)
        val c = a + b
        val d = b + a

        assertAll(
                { assertEquals(2, c.value) },
                { assertEquals(5, c.n) },
                { assertEquals(c.value, d.value) }
        )
    }

    @Test
    fun subtractionTest() {
        val a = ModuloInteger.of(3, 5)
        val b = ModuloInteger.of(1, 5)
        val c = a - b

        assertAll(
                { assertEquals(2, c.value) },
                { assertEquals(5, c.n) }
        )
    }

    @Test
    fun powerTest() {
        val a = ModuloInteger.of(2, 2389)
        val b = ModuloInteger.of(2, 67)
        val c = a `**` 10
        val d = b `**` 10

        assertAll(
                { assertEquals(1024, c.value) },
                { assertEquals(19, d.value) }
        )
    }
}