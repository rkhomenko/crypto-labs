package org.khomenko.crypto.labs.core.number.algo

import org.khomenko.crypto.labs.core.math.ContinuedFraction
import org.khomenko.crypto.labs.core.math.Semiconvergent
import kotlin.math.floor
import kotlin.math.sqrt

@ExperimentalUnsignedTypes
class WienerAttack(val pubKey: RSA.RSAKey) {
    var n = 0

    fun run(maxIter: Int = 1024): RSA.RSAKey? {
        val cf = ContinuedFraction(1.0 * pubKey.e / pubKey.n)
        val sc = Semiconvergent(cf)

        var p = 0.0
        var q = 0.0
        var privateExp = 0UL

        for ((k, d) in sc) {
            n++

            if (n > maxIter) {
                break
            }

            if (k == 0UL) {
                continue
            }

            val phi = floor((pubKey.e * d.toLong() - 1.0) / k.toLong()).toLong()
            // x^2 - ((N - phi) + 1)x + N = 0
            val b = - ((pubKey.n - phi) + 1)
            val disc2 = b * b - 4.0 * pubKey.n
            if (disc2 < 0) {
                continue
            }

            val disc = sqrt(disc2)

            p = 0.5 * (-b - disc)
            q = 0.5 * (-b + disc)

            val N = (p * q).toLong()
            if (p > 0 && q > 0 && N == pubKey.n) {
                privateExp = d
                break
            }
        }

        return if (privateExp != 0UL) {
            RSA.RSAKey(privateExp.toLong(), pubKey.n)
        } else {
            null
        }
    }
}