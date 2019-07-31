package ch05_program_with_lambda._01_lambdas_basics

fun salute() = println("Salute!")

fun main(args: Array<String>) {
    run(::salute)

    val getAge = Person::age

    val people = listOf(Person("Alice", 29), Person("Bob", 31))
    people.maxBy(Person::age)

    val createPerson = ::Person
    val p = createPerson("Alice", 29)
    println(p)
}
