package ch04_class_object_interface._03_class_and_interface

class User4(val name: String) {
    var address: String = "unspecified" // default value
        set(value: String) {
            println("""
                Address was changed for $name:
                "$field" -> "$value".""".trimIndent())
            field = value
        }
}

class LengthCounter {
    var counter: Int = 0
        private set // You can’t change this property outside of the class.

    fun addWord(word: String) {
        counter += word.length
    }
}

fun main(args: Array<String>) {
    val user = User4("Alice")
    user.address = "Elsenheimerstrasse 47, 80687 Muenchen"

    val lengthCounter = LengthCounter()
    lengthCounter.addWord("Hi!")
    println(lengthCounter.counter)
}
