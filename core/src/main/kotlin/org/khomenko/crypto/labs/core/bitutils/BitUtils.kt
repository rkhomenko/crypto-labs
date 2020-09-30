package org.khomenko.crypto.labs.core.bitutils

@ExperimentalUnsignedTypes
fun swapBits(a: UInt, i: Int, j: Int, n: Int = 1): UInt {
    val xorResult = ((a shr i) xor (a shr j)) and ((1u shl n) - 1u)
    return a xor ((xorResult shl i) or (xorResult shl j))
}

@ExperimentalUnsignedTypes
fun concatFirstLastBits(a: UInt, i: Int): UInt {
    val n = UInt.SIZE_BITS
    return ((a shr (n - i)) shl i) or ((a shl (n - i)) shr (n - i))
}

@ExperimentalUnsignedTypes
fun extractBetweenFirstLastBits(a: UInt, i: Int): UInt {
    val n = UInt.SIZE_BITS
    return (a shl i) shr (2 * i)
}