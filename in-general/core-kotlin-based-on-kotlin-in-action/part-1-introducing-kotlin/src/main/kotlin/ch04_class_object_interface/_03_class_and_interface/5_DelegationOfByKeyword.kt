package ch04_class_object_interface._03_class_and_interface

import java.util.*

// without "by"
class DelegatingCollection<T> : Collection<T> {
    private val innerList = arrayListOf<T>()
    override val size: Int get() = innerList.size
    override fun isEmpty(): Boolean = innerList.isEmpty()
    override fun contains(element: T): Boolean = innerList.contains(element)
    override fun iterator(): Iterator<T> = innerList.iterator()
    override fun containsAll(elements: Collection<T>): Boolean =
            innerList.containsAll(elements)
}

// with "by"
class DelegatingCollection2<T>(
        innerList: Collection<T> = ArrayList<T>()
) : Collection<T> by innerList {}

// Using class delegation
class CountingSet<T>(
        val innerSet: MutableCollection<T> = HashSet()
) : MutableCollection<T> by innerSet { // Delegates the MutableCollection implementation to innerSet

    var objectsAdded = 0

    override fun add(element: T): Boolean {
        objectsAdded++
        return innerSet.add(element)
    }

    override fun addAll(c: Collection<T>): Boolean {
        objectsAdded += c.size
        return innerSet.addAll(c)
    }
}

fun main(args: Array<String>) {
    val cset = CountingSet<Int>()
    cset.addAll(listOf(1, 1, 2))
    println("${cset.objectsAdded} objects were added, ${cset.size} remain")
}
