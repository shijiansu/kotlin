package ch02_kotlin_basics._06_Iterating_and_list

// Checking range membership using in
fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'

fun isNotDigit(c: Char) = c !in '0'..'9'

// Using in checks as when branches
fun recognize(c: Char) = when (c) {
    in '0'..'9' -> "It's a digit!"
    in 'a'..'z', in 'A'..'Z' -> "It's a letter!"
    else -> "I don't know…​"
}

fun main(args: Array<String>) {
    println(isLetter('q'))
    println(isNotDigit('x'))
    println(recognize('8')) // Checks whether the value is in the range from 0 to 9
    println("Kotlin" in "Java".."Scala") // he same as “Java” <= “Kotlin” && “Kotlin” <= “Scala”
}
