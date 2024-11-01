package org.example.classes

class Person constructor(private val name: String, private val age: Int){
    fun print() {
        println("Name $name, age $age")
    }

    fun isLegal() {
        if(this.age >= 18) {
            println("Is older than 18")
        } else {
            println("Is not older than 18")
        }
    }
}

class Person2(private val name: String, private var age: Int) {
    init {
        if(this.age < 0) {
            this.age = 0
        }
    }
    fun print() {
        println("Name $name, age $age")
    }
}

fun main() {
    val fran = Person("Franco", 30)
    fran.print()
    fran.isLegal()
}