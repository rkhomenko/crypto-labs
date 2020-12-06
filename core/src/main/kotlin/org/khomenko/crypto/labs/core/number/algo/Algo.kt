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

fun greatestCommonDivisor(a: Int, b: Int): Int {
    var x = a
    var y = b

    while (y != 0) {
        x %= y

        val t = y
        y = x
        x = t
    }
    return x
}

/**
 * @return GCD(a, b), x and y: a * x + b * y = GCD(a, b)
 */
fun greatestCommonDivisorExt(a: Int, b: Int): Triple<Int, Int, Int> {
    if (a == 0) {
        return Triple(b, 0, 1)
    }

    var coeffs1 = Pair(0, 1)
    var coeffs2 = Pair(1, 0)

    var a = a
    var b = b
    while (a != 0) {
        val k = b / a
        val tmp0 = Pair(b % a, a)
        a = tmp0.first
        b = tmp0.second

        val tmp1 = coeffs2
        coeffs2 = Pair(coeffs1.first - k * coeffs2.first, coeffs1.second - k * coeffs2.second)
        coeffs1 = tmp1
    }

    return Triple(b, coeffs1.first, coeffs1.second)
}

fun phi(n: Int): Int {
    var n = n
    var result = n
    var i = 2

    while (i * i <= n) {
        if (n % i == 0) {
            while (n % i == 0) {
                n /= i
            }
            result -= result / i
        }
        ++i
    }

    if (n > 1) {
        result -= result / n
    }

    return result
}