package org.example

import org.example.algorithms.binarySearch
import org.example.algorithms.fibonacci
import org.example.algorithms.graphs.implementation as DfsImplementation
import org.example.algorithms.reverseArray

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val reversedArray = reverseArray(mutableListOf(1,2,3))
    println("reversed arr: $reversedArray")
    val arr = listOf(1,8,2,21,40,14,19).sorted()
    val postion = binarySearch(arr, 40)
    println("index in the bs : $postion")
    val fibo10 = fibonacci(10)
    println("Fibonacci 10: $fibo10")
    DfsImplementation()
}