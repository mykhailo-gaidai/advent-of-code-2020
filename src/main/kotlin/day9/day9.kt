package day9

fun findFirstInvalidXMASItem(input: List<Long>, preambleCount: Int): Pair<Int, Long> {
    var index = preambleCount
    while (true) {
        if (index >= input.size) {
            return -1 to -1
        }
        val target = input[index]
        val preamble = input.subList(index - preambleCount, index)
        println("$target <- $preamble")
        preamble.flatMapIndexed { i, x ->
            preamble.filterIndexed { j, _ -> i != j }.map { y -> x  to y }
        }
            .firstOrNull { pair -> input[index] == pair.first + pair.second }?.let {
                println("${input[index]} = ${it.first} + ${it.second}")
            } ?: return index to input[index]

        index++
    }
}

fun findEncryptionWeakness(input: List<Long>, preambleCount: Int) {
    val (invalidIndex, target) = findFirstInvalidXMASItem(input, preambleCount)

    val newInput = input.take(invalidIndex)
    println("new input = $newInput")
    (0..newInput.size).forEach {
        println("$it/${newInput.size} -> ${newInput[it]}")
        val result = newInput.drop(it).reduceIndexed { index, acc, l ->
            val newAcc = acc + l

            if (newAcc == target) {
                val chain = newInput.drop(it).take(index + 1)
                println("target achieved; chain = $chain")
                val smallest = chain.minOrNull()!!
                val largest = chain.maxOrNull()!!
                println("smallest = $smallest, largest = $largest, result = ${smallest + largest}")
                return
            } else if (newAcc > target) {
                println("bust! $newAcc > $target")
                return@forEach
            }

            newAcc
        }

        if (result == target) {
            val chain = newInput.drop(it)
            println("target achieved; chain = $chain")
            val smallest = chain.minOrNull()!!
            val largest = chain.maxOrNull()!!
            println("smallest = $smallest, largest = $largest, result = ${smallest + largest}")
            return
        } else if (result > target) {
            println("bust! $result > $target")
        }

    }
}