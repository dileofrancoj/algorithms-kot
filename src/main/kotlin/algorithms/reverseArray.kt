package org.example.algorithms

fun <T>reverseArray(arr: MutableList<T>): MutableList<T> {
    var start = 0
    var end = arr.size - 1
    while(start < end) {
        val tmp = arr[start]
        arr[start] = arr[end]
        arr[end] = tmp
        start++
        end--
    }
    return arr
}