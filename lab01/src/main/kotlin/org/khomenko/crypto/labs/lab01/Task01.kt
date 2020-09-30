package org.khomenko.crypto.labs.lab01

import org.khomenko.crypto.labs.core.bitutils.swapBits
import org.khomenko.crypto.labs.core.io.readUntil;

@ExperimentalUnsignedTypes
fun main() {
    val radix = 2
    val chances = 3

    val intReader = { readLine()?.toInt()!! }

    println("Enter a number in binary format (a):")
    var a = readUntil(chances) { readLine()?.toUInt(radix)!! }

    println("Enter a number of bit (k) in the number (a):")
    val k = readUntil(chances, intReader)

    println("k-th bit is: ${(a shr k) and 1u}")

    a = a xor (1u shl k)
    println("Toggle k-th bit: ${a.toString(radix)}")

    println("Enter i and j line by line:")
    val i = readUntil(chances, intReader)
    val j = readUntil(chances, intReader)

    a = swapBits(a, i, j)
    println("Swap i and j-th bits of a: ${a.toString(radix)}")

    println("Enter number of bits (m):")
    val m = readUntil(chances, intReader)
    a = (a shr m) shl m
    println("Unset m first bits of a: ${a.toString(radix)}")
}