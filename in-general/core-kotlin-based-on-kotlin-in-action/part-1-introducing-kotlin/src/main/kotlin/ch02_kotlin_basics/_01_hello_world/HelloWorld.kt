package ch02_kotlin_basics._01_hello_world

fun main(args: Array<String>) {
    println("Hello, world!")
    // function
    println(max(1, 2))
    println(max2(1, 2))
    println(max3(1, 2))
}

// function
fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}

// expression body
fun max2(a: Int, b: Int): Int = if (a > b) a else b

// no return type
fun max3(a: Int, b: Int) = if (a > b) a else b
