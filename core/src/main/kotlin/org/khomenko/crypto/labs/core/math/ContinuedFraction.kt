package org.khomenko.crypto.labs.core.math

import kotlin.math.abs
import kotlin.math.floor

@ExperimentalUnsignedTypes
class ContinuedFraction(val alpha: Double, val eps: Double = 1e-6) : Iterable<Pair<ULong, Double>> {
    class CFIterator(var alpha: Double, val eps: Double) : Iterator<Pair<ULong, Double>> {
        private var first = true
        private var q = 0L

        override fun hasNext(): Boolean {
            return abs(alpha) > eps
        }

        override fun next(): Pair<ULong, Double> {
            if (first) {
                q = floor(alpha).toLong()
                alpha -= q
                first = false
            } else {
                q = floor(1.0 / alpha).toLong()
                alpha = 1.0 / alpha - q
            }
            return Pair(q.toULong(), alpha)
        }

    }

    override fun iterator(): Iterator<Pair<ULong, Double>> {
        return CFIterator(alpha, eps)
    }
}