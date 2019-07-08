package ch02_kotlin_basics._04_emun_and_when

import ch02_kotlin_basics._04_emun_and_when.Color.*

// Declaring a simple enum class
enum class Color {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
}

// Declaring an enum class with properties
enum class Color2(val r: Int, val g: Int, val b: Int) {
    RED(255, 0, 0),
    ORANGE(255, 165, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255),
    INDIGO(75, 0, 130),
    VIOLET(238, 130, 238);

    fun rgb() = (r * 256 + g) * 256 + b
}

// Using when for choosing the right enum value
// don’t need to write break statements in each branch
fun getMnemonic(color: Color): String {
    val s = when (color) {
        Color.RED -> "Richard"
        Color.ORANGE -> "Of"
        Color.YELLOW -> "York"
        Color.GREEN -> "Gave"
        Color.BLUE -> "Battle"
        Color.INDIGO -> "In"
        Color.VIOLET -> "Vain"
    }
    return s
}

// Combining options in one when branch
fun getWarmth(color: Color) = when (color) {
    Color.RED, Color.ORANGE, Color.YELLOW -> "warm"
    Color.GREEN -> "neutral"
    Color.BLUE, Color.INDIGO, Color.VIOLET -> "cold"
}

// Importing enum constants to access without qualifier
fun getWarmth2(color: Color) = when (color) {
    RED, ORANGE, YELLOW -> "warm"
    GREEN -> "neutral"
    BLUE, INDIGO, VIOLET -> "cold"
}

// Using different objects in when branches
fun mix(c1: Color, c2: Color) =
        when (setOf(c1, c2)) { // when the set, but not individual color value
            setOf(RED, YELLOW) -> ORANGE
            setOf(YELLOW, BLUE) -> GREEN
            setOf(BLUE, VIOLET) -> INDIGO
            else -> throw Exception("Dirty color")
        }

// when without an argument
// This function is the same thing as mix did earlier.
// Its advantage is that it does not create any extra objects,
// but the cost is that it’s harder to read.
fun mixOptimized(c1: Color, c2: Color) =
        when {
            (c1 == RED && c2 == YELLOW) ||
                    (c1 == YELLOW && c2 == RED) ->
                ORANGE

            (c1 == YELLOW && c2 == BLUE) ||
                    (c1 == BLUE && c2 == YELLOW) ->
                GREEN

            (c1 == BLUE && c2 == VIOLET) ||
                    (c1 == VIOLET && c2 == BLUE) ->
                INDIGO

            else -> throw Exception("Dirty color")
        }

fun main(args: Array<String>) {
    println(Color2.BLUE.rgb())
    println(getMnemonic(Color.BLUE))
    println(getWarmth(Color.ORANGE))
    println(getWarmth2(Color.ORANGE))
    println(mix(BLUE, YELLOW))
    println(mixOptimized(BLUE, YELLOW))
}
