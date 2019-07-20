package ch03_define_and_call_function._06_strings_and_regular_expressions

// Using String extensions for parsing paths
fun parsePath(path: String) {
    val directory = path.substringBeforeLast("/")
    val fullName = path.substringAfterLast("/")
    val fileName = fullName.substringBeforeLast(".")
    val extension = fullName.substringAfterLast(".")
    println("Dir: $directory, name: $fileName, ext: $extension")
}

// Using regular expressions for parsing paths
fun parsePath2(path: String) {
    val regex = """(.+)/(.+)\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)
    if (matchResult != null) {
        val (directory, filename, extension) = matchResult.destructured
        println("Dir: $directory, name: $filename, ext: $extension")
    }
}

// Multiline triple-quoted strings
val kotlinLogo = """| //
                   .|//
                   .|/ \"""

fun main(args: Array<String>) {
    // Splitting strings
    println("12.345-6.A".split("[.\\-]".toRegex()))
    println("12.345-6.A".split(".", "-"))

    parsePath("/Users/yole/kotlin-book/chapter.adoc")
    parsePath2("/Users/yole/kotlin-book/chapter.adoc")

    println(kotlinLogo.trimMargin("."))
}

