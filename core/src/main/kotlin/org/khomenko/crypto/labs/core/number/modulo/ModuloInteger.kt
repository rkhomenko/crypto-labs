package org.khomenko.crypto.labs.core.number.modulo

data class ModuloInteger private constructor(val value: Int,
                                             val n: Int) {
    companion object {
        fun of(value: Int, n: Int): ModuloInteger {
            return ModuloInteger(value % n, n)
        }

        fun assertSameModulo(a: ModuloInteger, b: ModuloInteger) {
            if (a.n != b.n) {
                throw RuntimeException("Arguments base not equal")
            }
        }
    }

    operator fun unaryPlus(): ModuloInteger {
        return this
    }

    operator fun unaryMinus(): ModuloInteger {
        return of(-value, n)
    }

    operator fun plus(b: ModuloInteger): ModuloInteger {
        assertSameModulo(this, b)
        return of((value + b.value) % n, n)
    }

    operator fun minus(b: ModuloInteger): ModuloInteger {
        return this + (-b);
    }

    operator fun times(b: ModuloInteger): ModuloInteger {
        assertSameModulo(this, b)
        return of((value * b.value) % n, n)
    }

    operator fun div(b: ModuloInteger): ModuloInteger {
        if (b.value == 0) {
            throw ArithmeticException("Division by zero")
        }
        return of((value / b.value) % n, n)
    }

    infix fun `**`(pow: Int): ModuloInteger {
        when(pow) {
            0 -> {
                if (value == 0) {
                    throw ArithmeticException("0^0 undefined")
                }
                return of(1, n)
            }
            1 -> return this
        }

        var z = pow
        var a = value
        var res = 1
        while (z > 0) {
            if (z and 1 > 0) {
                res *= a
                --z
            }

            a *= a
            z = z shr 1
        }

        return of(res, n)
    }
}