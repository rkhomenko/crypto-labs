package org.khomenko.crypto.labs.lab02

import org.khomenko.crypto.labs.core.io.readUntil
import org.khomenko.crypto.labs.core.number.algo.phi

fun main() {
    println("Calculate Euler's totient function. Enter n:")
    val n = readUntil(3, String::toInt)
    println("phi($n)=${phi(n)}")
}