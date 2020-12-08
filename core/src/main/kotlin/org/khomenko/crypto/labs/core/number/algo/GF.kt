package org.khomenko.crypto.labs.core.number.algo

import org.khomenko.crypto.labs.core.bitutils.getBit
import java.lang.ArithmeticException
import java.util.Stack
import kotlin.experimental.xor

@ExperimentalUnsignedTypes
class GF256 private constructor(val m: UShort) {

    class GF256Element(val a: UByte, val parent: GF256) {
        companion object {
            fun assertParent(a: GF256Element, b: GF256Element) {
                if (a.parent != b.parent) {
                    throw ArithmeticException("GF(256) elements parents do not matches")
                }
            }
        }

        operator fun plus(other: GF256Element): GF256Element {
            assertParent(this, other)
            return GF256Element(a xor other.a, this.parent)
        }

        operator fun minus(other: GF256Element): GF256Element {
            return this + other
        }

        operator fun times(other: GF256Element): GF256Element {
            assertParent(this, other)

            var a = a
            var b = other.a
            var result: UByte = 0u

            while (a.toUInt() != 0u && b.toUInt() != 0u) {
                if ((b.toUInt() and 0b1U) != 0u) {
                    result = result xor a
                }
                a = if ((a and 0x80u).toUInt() != 0U) {
                    ((a.toUInt() shl 1) xor parent.m.toUInt()).toUByte()
                } else {
                    (a.toUInt() shl 1).toUByte()
                }
                b = (b.toUInt() shr 1).toUByte()
            }

            return GF256Element(result, this.parent)
        }

        @ExperimentalUnsignedTypes
        override fun toString(): String {
            val stack = Stack<String>()

            if (getBit(a.toUInt(), 0).toInt() != 0) {
                stack.push("1")
            }
            for (i in 1..maxBits) {
                val ai = getBit(a.toUInt(), i).toInt()
                if (ai != 0) {
                    stack.push("x^${i}")
                }
            }

            return stack.joinToString(separator = " + ")
        }
    }

    companion object {
        private const val maxBits = UByte.SIZE_BITS
        const val AES: UShort = 0x11bU

        fun getInstance(m: UShort): GF256 {
            return GF256(m)
        }
    }

    fun getElement(a: UByte): GF256Element {
        return GF256Element(a, this)
    }
}