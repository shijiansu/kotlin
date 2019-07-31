package ch05_program_with_lambda._01_lambdas_basics

fun callLambdaStoredInVariable() {
    val sum = { x: Int, y: Int -> x + y }
    println(sum(1, 2))
}

fun callLambdaExpressionDirectly() {
    { println(42) }()
}

fun main(args: Array<String>) {
    callLambdaStoredInVariable()
    callLambdaExpressionDirectly()

    val people = listOf(Person("Alice", 29), Person("Bob", 31))
    // Passing a lambda as a named argument
    val names = people.joinToString(separator = " ", transform = { p: Person -> p.name })
    println(names)
    // Passing a lambda outside of parentheses
    val names2 = people.joinToString(" ") { p: Person -> p.name }
    println(names2)

    val sum = { x: Int, y: Int ->
        println("Computing the sum of $x and $y...")
        x + y
    }
    println(sum(1, 2))
}

