package ch02_kotlin_basics._02_string_template

fun main(args: Array<String>) {
    // approach - 1
    val name = if (args.size > 0) args[0] else "Kotlin"
    println("Hello, $name!")

    // approach - 2
    if (args.size > 0) {
        // include the $ character in a string, you escape it: println("\$x")
        // or use below approach,
        println("Hello, ${args[0]}!")
    }

    // approach 3 - use expression
    println("Hello, ${if (args.size > 0) args[0] else "someone"}!")
}
