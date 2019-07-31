package ch04_class_object_interface._03_class_and_interface

interface User2 {
    val nickname: String
}

class PrivateUser(override val nickname: String) : User2

class SubscribingUser(val email: String) : User2 {
    override val nickname: String
        get() = email.substringBefore('@')
}

fun getFacebookName(accountId: Int) = "fb:$accountId"

class FacebookUser(val accountId: Int) : User2 {
    override val nickname = getFacebookName(accountId)
}

interface User3 {
    val email: String
    val nickname: String
        get() = email.substringBefore('@')
}

fun main(args: Array<String>) {
    println(PrivateUser("test@kotlinlang.org").nickname)
    println(SubscribingUser("test@kotlinlang.org").nickname)
}
