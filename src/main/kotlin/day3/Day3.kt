package day3

fun calculateNumberOfTrees(input: List<String>, right: Int = 3, down: Int = 1): Int {
    var x = 0
    var y = 0
    var treeCount = 0
    while (true) {
        if (y >= input.size) break

        val current = input[y][x % input.first().length]
        if (current == '#') treeCount++

        x += right
        y += down
    }

    return treeCount
}