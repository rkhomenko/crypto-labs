package org.khomenko.crypto.labs.lab01

import org.khomenko.crypto.labs.core.bitutils.xorAllBits
import org.khomenko.crypto.labs.core.ext.toBinUInt
import org.khomenko.crypto.labs.core.io.readUntil

@ExperimentalUnsignedTypes
fun main() {
    println("Enter a number:")
    val a = readUntil(3, String::toBinUInt)
    println("Bits xor: ${xorAllBits(a)}")
}