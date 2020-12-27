package org.khomenko.crypto.labs.core.math

@ExperimentalUnsignedTypes
class Semiconvergent(val continuedFraction: ContinuedFraction) : Iterable<Pair<ULong, ULong>> {

        class SCIterator(val iterator: Iterator<Pair<ULong, Double>>) : Iterator<Pair<ULong, ULong>> {
            var p = mutableListOf(1UL, 0UL)
            var q = mutableListOf(0UL, 1UL)
            private var first = true

            override fun hasNext(): Boolean {
                return iterator.hasNext()
            }

            override fun next(): Pair<ULong, ULong> {
                val (a, _) = iterator.next()

                if (first) {
                    p[1] = a
                    first = false
                    return Pair(p[1], q[1])
                }

                val pn = a * p[1] + p[0]
                val qn = a * q[1] + q[0]


                p[0] = p[1]
                p[1] = pn
                q[0] = q[1]
                q[1] = qn

                return Pair(pn, qn)
            }
        }

    override fun iterator(): Iterator<Pair<ULong, ULong>> {
        return SCIterator(continuedFraction.iterator())
    }
}