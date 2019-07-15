package ch02_kotlin_basics._05_smart_cast

interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

// Evaluating expressions with an if-cascade
fun eval(e: Expr): Int {
    if (e is Num) {
        val n = e as Num // explicit cast to Num is redundant
        return n.value
    }
    if (e is Sum) {
        return eval(e.right) + eval(e.left) // smart-cast
    }
    throw IllegalArgumentException("Unknown expression")
}

fun eval2(e: Expr): Int =
        if (e is Num) {
            e.value
        } else if (e is Sum) {
            eval(e.right) + eval(e.left)
        } else {
            throw IllegalArgumentException("Unknown expression")
        }

// Using if-expressions that return values
fun eval3(e: Expr): Int =
        when (e) {
            is Num -> e.value
            is Sum -> eval(e.right) + eval(e.left)
            else -> throw IllegalArgumentException("Unknown expression")
        }

// Using when with compound actions in branches
fun evalWithLogging(e: Expr): Int =
        when (e) {
            is Num -> {
                println("num: ${e.value}")
                e.value // is returned if e is of type Num
            }
            is Sum -> {
                val left = evalWithLogging(e.left)
                val right = evalWithLogging(e.right)
                println("sum: $left + $right")
                left + right
            }
            else -> throw IllegalArgumentException("Unknown expression")
        }

fun main(args: Array<String>) {
    println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))
    println(eval2(Sum(Num(1), Num(2))))
    println(eval3(Sum(Num(1), Num(2))))
    println(evalWithLogging(Sum(Sum(Num(1), Num(2)), Num(4))))
}



