package org.example.classes

class Operations() {
    private var val1: Double = 0.0
    private var val2: Double = 0.0
    init {
        this.load()
    }
    private fun load() {
        print("Ingrese el primer valor")
        val1 = readln().toDouble()
        print("Ingrese el segundo valor")
        val2 = readln().toDouble()
        this.sum()
    }

    private fun sum() {
        println("La suma entre ${this.val1} y ${this.val2} es ${this.val1 + this.val2}")
    }
}

fun demo() {
    val op = Operations()
}