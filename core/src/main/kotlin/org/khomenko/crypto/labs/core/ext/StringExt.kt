package org.khomenko.crypto.labs.core.ext


@ExperimentalUnsignedTypes
fun String.toBinUInt(): UInt {
    return this.toUInt(2)
}

@ExperimentalUnsignedTypes
fun String.toBinULong(): ULong {
    return this.toULong(2)
}
