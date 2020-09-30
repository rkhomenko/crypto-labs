package org.khomenko.crypto.labs.core.bitutils

@ExperimentalUnsignedTypes
fun getBit(a: UInt, i: Int): UByte {
    return ((a shr i) and 1u).toUByte()
}

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

@ExperimentalUnsignedTypes
fun xorAllBits(a: UInt): UByte {
    var result: UInt = 0u
    var tmp = a

    while (tmp > 0u) {
        result = result xor (tmp and 1u)
        tmp = tmp shr 1
    }

    return result.toUByte()
}

//@ExperimentalUnsignedTypes
//infix fun UInt.cshl(n: UInt): UInt {
//    val mask: UInt = (UByte.SIZE_BITS * UInt.SIZE_BYTES).toUInt() - 1u;
//    val count = n and mask
//    return (this shl count.toInt()) or (this shr ((UInt.MAX_VALUE - count).toInt()) and mask)
//}

@ExperimentalUnsignedTypes
infix fun UInt.cshl(n: Int): UInt {
    return (this shl n) or (this shr (UInt.SIZE_BITS - n))
}

@ExperimentalUnsignedTypes
infix fun UInt.cshr(n: Int): UInt {
    return (this shr n) or (this shl (UInt.SIZE_BITS - n))
}