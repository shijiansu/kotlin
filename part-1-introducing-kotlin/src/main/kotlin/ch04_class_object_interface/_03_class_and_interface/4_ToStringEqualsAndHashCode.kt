package ch04_class_object_interface._03_class_and_interface

class Client(val name: String, val postalCode: Int) {
    // toString()
    override fun toString() = "Client(name=$name, postalCode=$postalCode)"
}

class Client2(val name: String, val postalCode: Int) {
    // equals()
    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Client2)
            return false
        return name == other.name &&
                postalCode == other.postalCode
    }

    // hashCode()
    override fun hashCode(): Int = name.hashCode() * 31 + postalCode

    override fun toString() = "Client2(name=$name, postalCode=$postalCode)"
}

// Data classes: autogenerated implementations of universal methods
data class Client3(val name: String, val postalCode: Int)

fun main(args: Array<String>) {
    val client1 = Client("Alice", 342562)
    println(client1)

    val client2 = Client("Alice", 342562)
    val client3 = Client("Alice", 342562)
    println(client2 == client3) // false

    val processed = hashSetOf(Client2("Alice", 342562))
    println(processed.contains(Client2("Alice", 342562))) // true

    val bob = Client3("Bob", 973293)
    println(bob.copy(postalCode = 382555))
    println(bob == Client3("Bob", 973293)) // true
}