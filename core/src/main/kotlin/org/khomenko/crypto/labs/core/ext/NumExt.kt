package org.khomenko.crypto.labs.core.ext

@ExperimentalUnsignedTypes
fun UInt.toBinString(): String {
    return this.toString(2)
}

@ExperimentalUnsignedTypes
fun ULong.toBinString(): String {
    return this.toString(2)
}