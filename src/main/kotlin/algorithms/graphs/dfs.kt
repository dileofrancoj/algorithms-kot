package org.example.algorithms.graphs

typealias GraphType = Map<Int, List<Int>>
typealias VisitedType = MutableList<Int>
fun dfsRecursive(graph: GraphType, start: Int, visited: VisitedType) {
    if(graph.isEmpty()) return
    println("Visitando Nodo: $start")
    visited.add(start)

    for(neighbor in graph[start]!!) {
        if(!visited.contains(neighbor)) {
            dfsRecursive(graph, start, visited)
        }
    }
}

fun dfs(graph: GraphType, start: Int) {
    val visited = mutableSetOf<Int>()
    val stack = mutableListOf<Int>() // Usaremos ArrayDeque como stack

    stack.add(start)

    while(stack.isNotEmpty()) {
        val node = stack.removeFirst()
        if(visited.contains(node)) continue
        visited.add(node)
        println("Visitando nodo: $node")

        for(neighbor in graph[node] ?: emptyList()) {
            if(!visited.contains(neighbor)) {
                stack.add(neighbor)
            }
        }
    }
}

fun implementation() {
    val graph:GraphType = mapOf(
        1 to listOf(2, 3),
        2 to listOf(4, 5),
        3 to listOf(6),
        4 to listOf(7),
        5 to emptyList(),
        6 to emptyList()
    )
    dfs(graph, 1)
}