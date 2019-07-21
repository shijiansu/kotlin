package ch05_program_with_lambda._01_lambdas_basics

data class Person(val name: String, val age: Int)

// Searching through a collection manually
fun findTheOldest(people: List<Person>) {
    var maxAge = 0 // Stores the maximum agepeople.maxBy
    var theOldest: Person? = null // Stores a person of the maximum age
    for (person in people) {
        if (person.age > maxAge) { // If the next person is older than the current oldest person, changes the maximum
            maxAge = person.age
            theOldest = person
        }
    }
    println(theOldest)
}

fun main(args: Array<String>) {
    val people = listOf(Person("Alice", 29), Person("Bob", 31))
    findTheOldest(people)

    println(people.maxBy { it.age }) // Finds the maximum by comparing the ages

    println(people.maxBy(Person::age)) // Searching using a member reference
}
