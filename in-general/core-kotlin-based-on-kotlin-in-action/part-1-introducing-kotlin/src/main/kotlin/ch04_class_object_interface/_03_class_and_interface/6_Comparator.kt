package ch04_class_object_interface._03_class_and_interface

import java.io.File
import java.util.*

// Implementing Comparator with an object
object CaseInsensitiveFileComparator : Comparator<File> {
    override fun compare(file1: File, file2: File): Int {
        return file1.path.compareTo(file2.path,
                ignoreCase = true)
    }
}

data class Person(val name: String) {
    // Implementing Comparator with a nested object
    object NameComparator : Comparator<Person> {
        override fun compare(p1: Person, p2: Person): Int =
                p1.name.compareTo(p2.name)
    }
}

fun main(args: Array<String>) {
    println(CaseInsensitiveFileComparator.compare(
            File("/User"), File("/user")))
    val files = listOf(File("/Z"), File("/a"))
    println(files.sortedWith(CaseInsensitiveFileComparator))

    val persons = listOf(Person("Bob"), Person("Alice"))
    println(persons.sortedWith(Person.NameComparator))
}
