package ch02_kotlin_basics._06_Iterating_and_list

import java.util.*

fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz "
    i % 3 == 0 -> "Fizz "
    i % 5 == 0 -> "Buzz "
    else -> "$i "
}

fun main(args: Array<String>) {
    // Using when to implement the Fizz-Buzz game
    for (i in 1..100) {
        print(fizzBuzz(i))
    }

    // Iterating over a range with a step
    for (i in 100 downTo 1 step 2) {
        print(fizzBuzz(i))
    }

    // Initializing and iterating over a map
    val binaryReps = TreeMap<Char, String>()
    for (c in 'A'..'F') {
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary // equivalent to its Java version - binaryReps.put(c, binary)
    }
    for ((letter, binary) in binaryReps) {
        println("$letter = $binary")
    }

    // Initializing and iterating over a list
    val list = arrayListOf("10", "11", "1001")
    for ((index, element) in list.withIndex()) {
        println("$index: $element")
    }
}
