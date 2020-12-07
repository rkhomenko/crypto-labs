package org.khomenko.crypto.labs.lab03

import org.khomenko.crypto.labs.core.io.readUntil
import org.khomenko.crypto.labs.core.number.algo.greatestCommonDivisorExt

fun main() {
    println("Execute extended GCD algorithm on a, b. Enter a, b:")
    val a = readUntil(3, String::toLong)
    val b = readUntil(3, String::toLong)

    val (r, x, y) = greatestCommonDivisorExt(a, b)
    println("Result: r=${r}, x=${x}, y=${y}")
    println("r == a * x + b * y = ${a * x + b * y}")
}