package ch03_define_and_call_function._05_collection

fun <T> List<T>.last(): T {
    return this[this.count() - 1]
}

fun Collection<Int>.max(): Int {
    return 9999
}

fun main(args: Array<String>) {
    // Extending the Java Collections API
    val strings: List<String> = listOf("first", "second", "fourteenth")
    println(strings.last())

    val numbers: Collection<Int> = setOf(1, 14, 2)
    println(numbers.max())

    // Varargs: functions that accept an arbitrary number of arguments
    val list = listOf("args: ", *args)
    println(list)

    // Working with pairs: infix calls and destructuring declarations
    val map = mapOf(1 to "one", 7 to "seven", 53 to "fifty-three")
    val (number, name) = 1 to ("one") // Calls the “to” function the regular way
    val (number2, name2) = 1 to "one" // Calls the “to” function using an infix notation

    for ((index, element) in list.withIndex()) {
        println("$index: $element")
    }
}
