package org.khomenko.crypto.labs.lab01

import kotlin.system.exitProcess

fun <T> readUntil(chances: Int, reader: () -> T): T {
    var value: T? = null
    for (i in 1..chances) {
        try {
            value = reader()
            break
        } catch (e: NumberFormatException) {
            println("Bad format. Try again:")
        }
    }

    if (value == null) {
        println("Cannot read a number. Exiting...")
        exitProcess(1)
    }

    return value
}

@ExperimentalUnsignedTypes
fun swapBits(a: UInt, i: Int, j: Int, n: Int): UInt {
    val xorResult = ((a shr i) xor (a shr j)) and ((1u shl n) - 1u)
    return a xor ((xorResult shl i) or (xorResult shl j))
}

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

    a = swapBits(a, i, j, 1)
    println("Swap i and j-th bits of a: ${a.toString(radix)}")

    println("Enter number of bits (m):")
    val m = readUntil(chances, intReader)
    a = (a shr m) shl m
    println("Unset m first bits of a: ${a.toString(radix)}")
}