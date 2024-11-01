package org.example.classes

import java.lang.Math

object Matematica {
    val PI = 3.14
    fun randomize(minimo: Int, maximo: Int) = ((Math.random() * (maximo + 1 - minimo)) + minimo).toInt()
}

fun main1() {
    println("El valor de PI es: ${Matematica.PI}")
    val randomVal = Matematica.randomize(5,10)

    val dices = object {
        val arr = IntArray(5)
        fun generate() {
            for (i in arr.indices) {
                arr[i] = ((Math.random() * 6) + 1).toInt()
            }
        }
        fun print() {
            for (element in arr) {
                println("$")
            }
        }
    }
}
