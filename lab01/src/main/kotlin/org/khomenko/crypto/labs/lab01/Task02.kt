package org.khomenko.crypto.labs.lab01

import org.khomenko.crypto.labs.core.bitutils.concatFirstLastBits
import org.khomenko.crypto.labs.core.ext.toBinString
import org.khomenko.crypto.labs.core.ext.toBinUInt
import org.khomenko.crypto.labs.core.io.readUntil

@ExperimentalUnsignedTypes
fun main() {
    val chances = 3

    println("Enter a 32-bit number:")
    val a = readUntil(chances, String::toBinUInt)

    println("Enter number of firs/last bits i:")
    val i = readUntil(chances, String::toInt)

    val firstLastConcat = concatFirstLastBits(a, i)
    println("Concatenation of firs/last i bits: ${firstLastConcat.toBinString()}")

}