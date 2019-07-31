package ch04_class_object_interface._02_inner_and_nested_classes

// Expressions as interface implementations
interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun eval(e: Expr): Int =
        when (e) {
            is Num -> e.value
            is Sum -> eval(e.right) + eval(e.left)
            else -> throw IllegalArgumentException("Unknown expression")
        }

// Expressions as sealed classes
sealed class Expr2 {
    // ist all the possible subclasses as nested classes
    class Num(val value: Int) : Expr2()
    class Sum(val left: Expr2, val right: Expr2) : Expr2()
}

fun eval(e: Expr2): Int =
        when (e) {
            is Expr2.Num -> e.value
            is Expr2.Sum -> eval(e.right) + eval(e.left)
        }

fun main(args: Array<String>) {
    println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))

    println(eval(Expr2.Sum(Expr2.Sum(Expr2.Num(1), Expr2.Num(2)), Expr2.Num(4))))
}
