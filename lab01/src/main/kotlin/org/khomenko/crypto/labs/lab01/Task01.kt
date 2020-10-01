package org.khomenko.crypto.labs.lab01

import org.khomenko.crypto.labs.core.bitutils.getBit
import org.khomenko.crypto.labs.core.bitutils.swapBits
import org.khomenko.crypto.labs.core.ext.toBinString
import org.khomenko.crypto.labs.core.ext.toBinUInt
import org.khomenko.crypto.labs.core.io.readUntil

@ExperimentalUnsignedTypes
fun main() {
    val chances = 3

    println("Enter a number in binary format (a):")
    var a = readUntil(chances, String::toBinUInt)

    println("Enter a number of bit (k) in the number (a):")
    val k = readUntil(chances, String::toInt)

    println("k-th bit is: ${getBit(a, k)}")

    a = a xor (1u shl k)
    println("Toggle k-th bit: ${a.toBinString()}")

    println("Enter i and j line by line:")
    val i = readUntil(chances, String::toInt)
    val j = readUntil(chances, String::toInt)

    a = swapBits(a, i, j)
    println("Swap i and j-th bits of a: ${a.toBinString()}")

    println("Enter number of bits (m):")
    val m = readUntil(chances, String::toInt)
    a = (a shr m) shl m
    println("Unset m first bits of a: ${a.toBinString()}")
}