package ch02_kotlin_basics._07_try_catch_and_final

import java.io.BufferedReader
import java.io.StringReader

// Using try as in Java
fun readNumber(reader: BufferedReader): Int? {
    try {
        val line = reader.readLine()
        return Integer.parseInt(line)
    } catch (e: NumberFormatException) {
        return null
    } finally {
        reader.close()
    }
}

// Using try as an expression
fun readNumber2(reader: BufferedReader) {
    val number = try {
        Integer.parseInt(reader.readLine())
    } catch (e: NumberFormatException) {
        return
    }
    println(number)
}

// Returning a value in catch
fun readNumber3(reader: BufferedReader) {
    val number = try {
        Integer.parseInt(reader.readLine())
    } catch (e: NumberFormatException) {
        null
    }
    println(number)
}

fun main(args: Array<String>) {
    println(readNumber(BufferedReader(StringReader("239"))))
    readNumber2(BufferedReader(StringReader("not a number")))
    readNumber3(BufferedReader(StringReader("not a number")))
}
