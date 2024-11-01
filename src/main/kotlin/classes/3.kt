package org.example.classes

class Person3 {
    var name: String = ""
        set(value) {
            field = value.uppercase()
        }
        get() {
            return "($field)"
        }
    var age: Int = 0
        set(value) {
            field = if(value >= 0) value
            else 0
        }
}

fun main() {
    val fran = Person3()
    fran.name = "Franco"
    fran.age = 30
    println(fran.name)
}