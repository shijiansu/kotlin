package ch04_class_object_interface._01_class_hierarchies

interface Clickable {
    fun click()
    // Method with a default implementation
    fun showOff() = println("I'm clickable!") // Defining a method with a body in an interface
}

class Button : Clickable {
    override fun click() = println("I was clicked")
}

interface Focusable {
    fun setFocus(b: Boolean) = println("I ${if (b) "got" else "lost"} focus.")
    // Defining another interface implementing the same method
    fun showOff() = println("I'm focusable!")
}

class Button2 : Clickable, Focusable {
    override fun click() = println("I was clicked")

    // Neither one wins. Instead, you get the following compiler error
    // if you don’t implement showOff explicitly
    override fun showOff() {
        // Invoking an inherited interface method implementation
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }
    // if only want to implement one showOff logic;
    // override fun showOff() = super<Clickable>.showOff()
}

open class RichButton : Clickable { // This class is open: others can inherit from it.
    fun disable() {} // This function is final: you can’t override it in a subclass.
    open fun animate() {} // This function is open: you may override it in a subclass.
    // This function overrides an open function and is open as well.
    // override fun click() {}
    // Forbidding an override
    final override fun click() {}
}

abstract class Animated { // This class is abstract: you can’t create an instance of it.
    abstract fun animate() // This function is abstract: it doesn’t have an implementation and must be overridden in subclasses.
    open fun stopAnimating() {} // Non-abstract functions in abstract classes aren’t open by default but can be marked as open.
    fun animateTwice() {}
}

fun main(args: Array<String>) {
    Button().click()

    val button = Button2()
    button.showOff()
    button.setFocus(true)
    button.click()
}
