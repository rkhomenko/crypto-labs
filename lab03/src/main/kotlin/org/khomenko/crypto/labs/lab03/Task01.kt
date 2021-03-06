package org.khomenko.crypto.labs.lab03

import org.khomenko.crypto.labs.core.io.readUntil
import org.khomenko.crypto.labs.core.number.modulo.ModuloInteger

fun main() {
    println("Calculate fast a^b modulo n. Enter a, b and n:")
    val a = readUntil(3, String::toLong)
    val b = readUntil(3, String::toLong)
    val n = readUntil(3, String::toLong)
    val aModulo = ModuloInteger.of(a, n)

    println("Result: ${aModulo `**` b}")
}