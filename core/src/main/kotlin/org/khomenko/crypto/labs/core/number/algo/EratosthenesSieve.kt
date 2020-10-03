package org.khomenko.crypto.labs.core.number.algo

import java.util.stream.Collectors

fun eratosthenesSieve(n: Int): List<Int> {
    val mark = -1

    if (n <= 0) {
        throw RuntimeException("Bad number. Must be > 0")
    }

    when (n) {
        1, 2 -> return listOf()
        3 -> return listOf(2)
    }

    val numbers = ArrayList<Int>(n - 1);
    for (i in 0 until n - 1) {
        numbers.add(i + 1)
    }

    var p = 2
    do {
        for (i in p * p - 1 until n - 1 step p) {
            numbers[i] = mark
        }
        p = numbers.stream()
                .skip(p.toLong())
                .filter { it != mark }
                .findFirst()
                .orElseThrow()
    } while (p * p < n - 1)

    return numbers.stream()
            .skip(1)
            .filter { it != mark }
            .collect(Collectors.toList())
}