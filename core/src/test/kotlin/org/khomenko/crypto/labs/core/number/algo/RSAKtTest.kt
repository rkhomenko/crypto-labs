package org.khomenko.crypto.labs.core.number.algo

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.security.MessageDigest
import kotlin.random.Random

@ExperimentalUnsignedTypes
class RSAKtTest {
    @Test
    fun stringRSAEncryptDecryptTest() {
        val (publicKey, privateKey) = RSA.generateKeys()
        val input = Random.nextLong(0, 1000000)
        val encrypted = RSA.encrypt(input, publicKey)
        val decrypted = RSA.decrypt(encrypted, privateKey)

        Assertions.assertEquals(input, decrypted)
    }
}