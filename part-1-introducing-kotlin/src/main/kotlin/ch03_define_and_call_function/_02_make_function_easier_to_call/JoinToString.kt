package ch03_define_and_call_function._02_make_function_easier_to_call

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
fun <T> Collection<T>.joinToStringFinal(
        separator: String = ", ",
        prefix: String = "",
        postfix: String = ""
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

// Utility Functions As Extensions
fun Collection<String>.join(
        separator: String = ", ",
        prefix: String = "",
        postfix: String = ""
) = joinToString(separator, prefix, postfix)

fun main(args: Array<String>) {
    val list = listOf(1, 2, 3)
    println(joinToString(list, "; ", "(", ")"))

    val list2 = listOf(1, 2, 3)
    println(list2.joinToStringFinal(separator = "; ", prefix = "(", postfix = ")"))

    println(listOf("one", "two", "eight").join(" "))
}
