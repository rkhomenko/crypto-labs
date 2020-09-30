package org.khomenko.crypto.labs.lab01

import org.khomenko.crypto.labs.core.bitutils.cshl
import org.khomenko.crypto.labs.core.bitutils.cshr
import org.khomenko.crypto.labs.core.ext.toBinString
import org.khomenko.crypto.labs.core.ext.toBinUInt
import org.khomenko.crypto.labs.core.io.readUntil

@ExperimentalUnsignedTypes
fun main() {
    println("Enter a number:")
    val a = readUntil(3, String::toBinUInt)

    println("Enter shift bits count:")
    val n = readUntil(3, String::toInt)

    println("Left circular shift: ${(a cshl n).toBinString()}")
    println("Right circular shift: ${(a cshr n).toBinString()}")
}