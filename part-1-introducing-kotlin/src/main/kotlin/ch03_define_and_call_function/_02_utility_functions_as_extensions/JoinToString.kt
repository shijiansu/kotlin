// @file:JvmName("StringFunctions") // calls by Jaa and acting as class name in static method

package ch03_define_and_call_function._02_utility_functions_as_extensions

// Declaring joinToString() as a top-level function
// Initial implementation of joinToString()
fun <T> joinToString(
        collection: Collection<T>,
        separator: String,
        prefix: String,
        postfix: String
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

// Declaring joinToString() with default parameter values
fun <T> joinToString2(
        collection: Collection<T>,
        separator: String = ", ",
        prefix: String = "",
        postfix: String = ""
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

// Adding methods to other people’s classes: extension functions and properties
// extension function,
// is a simple thing: it’s a function that can be called as a member of a class but is defined outside of it.
//fun String.lastChar(): Char = this.get(this.length - 1)
fun String.lastChar(): Char = get(length - 1) // able to remove this

// Utility functions as extensions
fun <T> Collection<T>.join(
        separator: String = ", ",
        prefix: String = "",
        postfix: String = ""
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in this.withIndex()) { // collection of T
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

// Utility Functions As Extensions
fun Collection<String>.join2(
        separator: String = ", ",
        prefix: String = "",
        postfix: String = ""
) = joinToString(separator, prefix, postfix)

fun main(args: Array<String>) {
    val list = listOf("1", "2", "3")
    println(joinToString(list, "; ", "(", ")"))
    // default parameters
    println(joinToString2(list))
    println(joinToString2(list, "; "))
    // named parameters
    println(joinToString2(list, postfix = ";", prefix = "# "))

    println(list.join(separator = "; ", prefix = "(", postfix = ")"))

    println(list.join2(" "))
}
