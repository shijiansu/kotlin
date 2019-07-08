package ch02_kotlin_basics._03_class_and_properties

// In Kotlin, public is the default visibility, so you can omit it.
class Person(
        val name: String,
        var isMarried: Boolean
)

fun main(args: Array<String>) {
    val person = Person("Bob", true)
    println(person.name)
    println(person.isMarried)
}
