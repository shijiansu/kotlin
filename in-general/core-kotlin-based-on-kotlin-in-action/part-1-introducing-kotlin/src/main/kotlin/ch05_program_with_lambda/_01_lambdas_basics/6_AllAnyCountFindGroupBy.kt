package ch05_program_with_lambda._01_lambdas_basics

val canBeInClub27 = { p: Person -> p.age <= 27 }

fun main(args: Array<String>) {
    val people = listOf(
            Person("Alice", 27),
            Person("Bob", 31),
            Person("Carol", 31))
    println(people.all(canBeInClub27)) // all is, return boolean
    println(people.find(canBeInClub27)) // return object
    println(people.groupBy { it.age })  // return map

    val list = listOf(1, 2, 3)
    println(!list.all { it == 3 }) // true
    println(list.any { it != 3 }) // true

    val list2 = listOf("a", "ab", "b")
    println(list2.groupBy(String::first))
}
