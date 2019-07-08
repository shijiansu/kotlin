package ch02_kotlin_basics._03_class_and_properties

import java.util.*

// In Kotlin, you can put multiple classes in the same file
// and choose any name for that file.
class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        // get() {
        //   return height == width
        // }
        get() = height == width
}

fun createRandomRectangle(): Rectangle {
    val random = Random()
    return Rectangle(random.nextInt(), random.nextInt())
}

fun main(args: Array<String>) {
    val rectangle = Rectangle(41, 43)
    println(rectangle.isSquare)
}
