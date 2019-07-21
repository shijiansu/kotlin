package ch04_class_object_interface._02_inner_and_nested_classes

class Outer {
    inner class Inner {
        fun getOuterReference(): Outer = this@Outer
    }
}
