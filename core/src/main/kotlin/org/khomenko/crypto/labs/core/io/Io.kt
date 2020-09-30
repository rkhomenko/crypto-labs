package org.khomenko.crypto.labs.core.io

import kotlin.system.exitProcess

fun <T> readUntil(chances: Int, reader: () -> T): T {
    var value: T? = null
    for (i in 1..chances) {
        try {
            value = reader()
            break
        } catch (e: NumberFormatException) {
            println("Bad format. Try again:")
        }
    }

    if (value == null) {
        println("Cannot read a number. Exiting...")
        exitProcess(1)
    }

    return value
}