package day10

fun calculateAdapterChain(input: List<Int>) {
    val results = IntArray(3) { 0 }

    val sortedInput = input.sorted()
    sortedInput.windowed(2, 1).forEach { results[it[1] - it[0] - 1]++ }

    results[sortedInput.first() - 1]++
    results[2]++

    results.forEachIndexed { index, i ->
        println("results[${index + 1}] = $i")
    }
    println("the answer is ${results[0] * results[2]}")
}

fun calculateNumberOfPermutations(input: List<Int>) {
    val deltas = (listOf(0) + input.sorted() + listOf(input.maxOrNull()!! + 3)).windowed(2, 1).map { it[1] - it[0] }
    var chain = 0
    var result = 1L

    deltas.forEach {
        if (it == 1) {
            chain++
        } else {
            result *= when (chain) {
                2 -> 2
                3 -> 4
                4 -> 7
                else -> 1
            }
            chain = 0
        }
    }

    result *= when (chain) {
        2 -> 2
        3 -> 4
        4 -> 7
        else -> 1
    }

    println(result)
}