package org.khomenko.crypto.labs.lab03

import org.khomenko.crypto.labs.core.io.readUntil
import org.khomenko.crypto.labs.core.number.algo.RSA

@ExperimentalUnsignedTypes
fun main() {
    println("Encrypt message by RSA. Enter a number:")
    val m = readUntil(3, String::toLong)

    val (publicKey, privateKey) = RSA.generateKeys()
    println("e=${privateKey.e}, d=${publicKey.e}, n=${publicKey.n}")

    val encrypted = RSA.encrypt(m, publicKey)
    println("Encrypted message: $encrypted")

    val decrypted = RSA.decrypt(encrypted, privateKey)
    println("Decrypted message: $decrypted")
}