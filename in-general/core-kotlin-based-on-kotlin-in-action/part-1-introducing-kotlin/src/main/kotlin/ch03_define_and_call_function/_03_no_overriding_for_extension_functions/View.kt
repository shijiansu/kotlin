package ch03_define_and_call_function._03_no_overriding_for_extension_functions


open class View {
    open fun click() = println("View clicked")
}

// Overriding a member function
class Button: View() { // extends from View
    override fun click() = println("Button clicked")
}

// No overriding for extension functions
fun View.showOff() = println("I'm a view!")
fun Button.showOff() = println("I'm a button!")

fun main(args: Array<String>) {
    val view: View = Button()
    view.click() // Button clicked
    view.showOff() // I'm a view!
}
