package ch04_class_object_interface._02_inner_and_nested_classes

import java.io.Serializable

interface State : Serializable

interface View {
    fun getCurrentState(): State
    fun restoreState(state: State) {}
}

class Button : View {
    override fun getCurrentState(): State = ButtonState()
    override fun restoreState(state: State) { /*...*/
    }

    class ButtonState : State { /*...*/ } // This class is an analogue of a static nested class in Java.
}
