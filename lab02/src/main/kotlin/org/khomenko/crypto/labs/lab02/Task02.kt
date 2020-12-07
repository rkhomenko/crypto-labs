package org.khomenko.crypto.labs.lab02

import org.khomenko.crypto.labs.core.io.readUntil
import org.khomenko.crypto.labs.core.number.algo.greatestCommonDivisor
import java.util.stream.Collectors
import java.util.stream.LongStream

fun main() {
    println("Construct multiplicative group of integers modulo n. Enter n:")
    val n = readUntil(3, String::toLong)

    val group = LongStream.range(1, n)
            .filter { greatestCommonDivisor(it, n) == 1L }
            .boxed()
            .collect(Collectors.toList())

    println("Result: $group")
}