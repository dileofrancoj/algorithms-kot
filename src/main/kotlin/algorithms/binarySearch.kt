package org.example.algorithms

typealias Type = List<Int>
// The list must be sorted previously
fun binarySearch(arr: Type, target: Int): Int {

    var left = 0
    var right = arr.size - 1

    while (left <= right) {
        val middle = (left + right) / 2
        when {
            arr[middle] == target -> return middle
            arr[middle] < target -> left = middle + 1
            arr[middle] > target -> right = middle - 1
        }
    }

    return -1
}