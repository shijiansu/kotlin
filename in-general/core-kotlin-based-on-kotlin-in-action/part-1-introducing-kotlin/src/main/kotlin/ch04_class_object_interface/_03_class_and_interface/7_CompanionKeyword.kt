package ch04_class_object_interface._03_class_and_interface

class A {
    companion object {
        fun bar() {
            println("Companion object called")
        }
    }
}

fun getFacebookName2(accountId: Int) = "fb:$accountId"

class User5 private constructor(val nickname: String) { // Marks the primary constructor as private
    // Declares the companion object
    companion object {
        // Declaring a named companion object
        fun newSubscribingUser(email: String) =
                User5(email.substringBefore('@'))

        // Factory method creating a new user by Facebook account ID
        fun newFacebookUser(accountId: Int) =
                User5(getFacebookName2(accountId))
    }
}

// Declaring a named companion object
class Person2(val name: String) {
    companion object Loader {
        fun fromJSON(jsonText: String): Person2 = Person2(jsonText)
    }
}

// Implementing an interface in a companion object
interface JSONFactory<T> {
    fun fromJSON(jsonText: String): T
}

class Person3(val name: String) {
    companion object : JSONFactory<Person3> {
        override fun fromJSON(jsonText: String): Person3 = Person3(jsonText)
    }
}

// function that uses an abstract factory to load entities
fun <T> loadFromJSON(factory: JSONFactory<T>, jsonText: String): T {
    return factory.fromJSON(jsonText)
}


// Defining an extension function for a companion object
// business logic module
class Person4(val firstName: String, val lastName: String) {
    companion object {
    }
}

fun Person4.Companion.fromJSON(json: String): Person4 {
    return Person4("firstName", "lastName")
}


fun main(args: Array<String>) {
    A.bar()

    val subscribingUser = User5.newSubscribingUser("bob@gmail.com")
    val facebookUser = User5.newFacebookUser(4)
    println(subscribingUser.nickname)

    val person = Person2.Loader.fromJSON("{name: 'Dmitry'}")
    println(person.name)
    val person2 = Person2.fromJSON("{name: 'Brent'}")
    println(person2.name)

    loadFromJSON(Person3, "{name: 'Brent'}")

    val p = Person4.fromJSON("{name: 'Brent'}")
}
