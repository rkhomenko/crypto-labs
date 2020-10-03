package org.khomenko.crypto.labs.lab02

import org.khomenko.crypto.labs.core.io.readUntil
import org.khomenko.crypto.labs.core.number.algo.eratosthenesSieve

fun main() {
    println("Find all prime numbers less n. Enter n:")
    val n = readUntil(3, String::toInt)

    println("Result: ${eratosthenesSieve(n)}")
}