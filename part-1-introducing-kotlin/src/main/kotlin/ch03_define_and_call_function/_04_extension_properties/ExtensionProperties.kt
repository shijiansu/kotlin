package ch03_define_and_call_function._04_extension_properties

// Declaring an extension property
val String.lastChar: Char
    get() = get(length - 1) // getter for lastChar properties

// Declaring a mutable extension property
var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value: Char) {
        this.setCharAt(length - 1, value)
    }

//fun String.lastChar(): Char = this.get(this.length - 1)
//fun String.lastChar(): Char = this[this.length - 1]
fun String.lastChar(): Char = this[length - 1]

fun main(args: Array<String>) {
    println("Kotlin".lastChar)

    val sb = StringBuilder("Kotlin?")
    sb.lastChar = '!'
    println(sb)

    println("Kotlin".lastChar())

}
