package org.khomenko.crypto.labs.core.ext


@ExperimentalUnsignedTypes
fun String.toBinUInt(): UInt {
    return this.toUInt(2)
}

@ExperimentalUnsignedTypes
fun String.toBinULong(): ULong {
    return this.toULong(2)
}

@ExperimentalUnsignedTypes
fun String.toBinUByte(): UByte {
    return this.toUByte(2)
}

fun String.toBinByte(): Byte {
    return this.toByte(2)
}
