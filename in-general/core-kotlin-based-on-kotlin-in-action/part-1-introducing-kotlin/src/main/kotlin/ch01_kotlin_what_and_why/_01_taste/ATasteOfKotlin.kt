package ch01_kotlin_what_and_why._01_taste

data class Person(
        val name: String,
        val age: Int? = null
)

// functional programming
//fun findAlice() = findPerson { it.name == "Alice" }
//fun findBob() = findPerson { it.name == "Bob" }

fun main(args: Array<String>) {
    val persons = listOf(Person("Alice"), Person("Bob", age = 29))

    val oldest = persons.maxBy { it.age ?: 0 }
    println("The oldest is: $oldest")
}

// The oldest is: Person(name=Bob, age=29)

// ----------------------------------------

// Kotlin on the server side
//fun renderPersonList(persons: Collection<Person>) = {
//    creaetHTML().table {
//        for (person in persons) {
//            tr {
//                td { +person.name }
//                td { +person.age }
//            }
//        }
//    }
//}

// ----------------------------------------

// https://github.com/jetbrains/exposed
//object CountryTable : IdTable() { //描述一个数据库表
//    val name = varchar("name", 250).uniqueIndex()
//    val iso = varchar("iso", 2).uniqueIndex()
//}
//class Country(id: EntityID) : Entity(id) { //创建一个相应数据库entity的类
//    var name: String by CountryTable.name
//    var iso: String by CountryTable.iso
//}
//val russia = Country.find {//用纯粹的Kotlin代码查询这个数据库
//    CountryTable.iso.eq("ru")
//}.first()
//
//println(russia.name)
