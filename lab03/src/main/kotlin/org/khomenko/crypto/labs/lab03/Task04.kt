package org.khomenko.crypto.labs.lab03

import org.khomenko.crypto.labs.core.ext.toBinUByte
import org.khomenko.crypto.labs.core.io.readUntil
import org.khomenko.crypto.labs.core.number.algo.GF256

@ExperimentalUnsignedTypes
fun main() {
    println("Calculate sum and prod of two GF(256) elements a, b. Enter a, b:")
    val aBits = readUntil(3, String::toBinUByte)
    val bBits = readUntil(3, String::toBinUByte)

    val gf256 = GF256.getInstance(GF256.AES)
    val a = gf256.getElement(aBits)
    val b = gf256.getElement(bBits)

    println("a(x) = ${a}")
    println("b(x) = ${b}")
    println("a(x) + b(x) = ${a + b}")
    println("a(x) * b(x) = ${a * b}")
}