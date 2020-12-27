package org.khomenko.crypto.labs.lab04

import org.khomenko.crypto.labs.core.number.algo.RSA
import org.khomenko.crypto.labs.core.number.algo.WienerAttack

@ExperimentalUnsignedTypes
fun main() {
    //val wa = WienerAttack(RSA.RSAKey(1073780833, 1220275921)) // d = 25
    val wa = WienerAttack(RSA.RSAKey(1779399043, 2796304957)) // d = 11
    val pk = wa.run()!!
    println("${pk.e}, ${wa.n}")
}