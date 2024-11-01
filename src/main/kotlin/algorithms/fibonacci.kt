package org.example.algorithms

fun fibonacci(n : Int): Int {
    if(n == 0) return 0
    if(n == 1) return 1
    return fibonacci(n-1) + fibonacci(n - 2)
}

typealias MemoType = MutableMap<Int, Int>

fun memoizedFib(n : Int, memo: MemoType): Int {
    if(n < 0) throw IllegalArgumentException("Invalid input")
    if(n <= 1) return n
    if(n in memo) return memo[n]!!
    val value = memoizedFib(n-1, memo) + memoizedFib(n-2, memo)
    memo[n] = value
    return value
}