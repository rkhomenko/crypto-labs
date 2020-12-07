package org.khomenko.crypto.labs.core.number.algo

import org.khomenko.crypto.labs.core.number.modulo.ModuloInteger
import java.nio.ByteBuffer
import java.nio.IntBuffer
import kotlin.random.Random
import kotlin.random.nextULong

@ExperimentalUnsignedTypes
class RSA {
    class RSAKey constructor(val e: Long, val n: Long)

    companion object {
        private const val randomMin = 0b1 shl 14
        private const val randomMax = 0b1 shl 16

        private fun generateRandomPrime(): Long {
            while (true) {
                val r = Random.nextLong(randomMin.toLong(), randomMax.toLong())
                if (fermatPrimalityTest(r)) {
                    return r
                }
            }
        }

        /**
         * @return public and private RSAKey
         */
        fun generateKeys(): Pair<RSAKey, RSAKey> {
            val p = generateRandomPrime()
            val q = generateRandomPrime()
            val n = p * q // module
            val phiValue = (p - 1L) * (q - 1L)

            // Find public exponent e
            // 1 < e < phi(n) and e is coprime with phi(n)
            // Prefer greater e values
            val e = LongRange(phiValue / 3L, phiValue - 1L)
                    .first { greatestCommonDivisor(it, phiValue) == 1L }
                    .toLong()

            // Find private exponent
            // d * e = 1 (mod phi(n))
            var (_, d, _) = greatestCommonDivisorExt(e, phiValue)

            while (d < 0L) {
                d += phiValue
            }

            return Pair(RSAKey(e, n), RSAKey(d, n))
        }

        fun encrypt(message: Long, publicKey: RSAKey): Long {
            return (ModuloInteger.of(message, publicKey.n) `**` publicKey.e).value
        }

        fun decrypt(message: Long, privateKey: RSAKey): Long {
            return (ModuloInteger.of(message, privateKey.n) `**` privateKey.e).value
        }
    }


}