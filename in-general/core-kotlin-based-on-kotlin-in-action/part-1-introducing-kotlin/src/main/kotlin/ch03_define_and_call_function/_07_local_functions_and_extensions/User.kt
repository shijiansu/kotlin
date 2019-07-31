package ch03_define_and_call_function._07_local_functions_and_extensions

// A function with repetitive code
class User(val id: Int, val name: String, val address: String)

fun saveUser(user: User) {
    if (user.name.isEmpty()) {
        throw IllegalArgumentException("Can't save user ${user.id}: empty Name")
    }
    if (user.address.isEmpty()) {
        throw IllegalArgumentException("Can't save user ${user.id}: empty Address")
    }
    // Save user to the database
}

// Extracting a local function to avoid repetition
fun saveUser2(user: User) {
    fun validate(user: User, value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Can't save user ${user.id}: empty $fieldName")
        }
    }
    validate(user, user.name, "Name")
    validate(user, user.address, "Address")
    // Save user to the database
}

// Accessing outer function parameters in a local function
fun saveUser3(user: User) {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Can't save user ${user.id}: " + "empty $fieldName")
        }
    }
    validate(user.name, "Name")
    validate(user.address, "Address")
    // Save user to the database
}

// Extracting the logic into an extension function
fun User.validateBeforeSave() {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Can't save user $id: empty $fieldName")
        }
    }
    validate(name, "Name")
    validate(address, "Address")
}

fun saveUser4(user: User) {
    user.validateBeforeSave()
    // Save user to the database
}

fun main(args: Array<String>) {
    saveUser(User(1, "", ""))
    saveUser2(User(1, "", ""))
    saveUser3(User(1, "", ""))
    saveUser4(User(1, "", ""))

}
