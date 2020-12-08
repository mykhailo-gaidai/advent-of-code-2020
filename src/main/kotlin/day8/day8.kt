package day8

fun tryFixInstructions(input: List<String>) {
    val jumps = input.mapIndexed { index, s -> index to s }.filter { it.second.startsWith("jmp") }
    val nops = input.mapIndexed { index, s -> index to s }.filter { it.second.startsWith("nop") }
    println("${jumps.size} jumps, ${nops.size} nops")

    jumps.forEachIndexed { index, pair ->
        val modifiedInput = input.toMutableList().apply {
            set(pair.first, pair.second.replace("jmp", "nop"))
        }
        val result = runProgram(modifiedInput)
        println("jmp ${index +1}/${jumps.size} -> $result")
    }

    nops.forEachIndexed { index, pair ->
        val modifiedInput = input.toMutableList().apply {
            set(pair.first, pair.second.replace("nop", "jmp"))
        }
        val result = runProgram(modifiedInput)
        println("nop ${index +1}/${jumps.size} -> $result")
    }
}

fun runProgram(input: List<String>): Int {
    var acc = 0
    val visited = IntArray(input.size) { 0 }
    var index = 0

    while (true) {
        if (visited[index] > 1) {
            return -1
        }

        val parts = input[index].trim().split(' ')
        val instruction = parts[0]
        val arg = parts[1].toInt()

        when (instruction) {
            "acc" -> {
                acc += arg
                index++
            }
            "jmp" -> index += arg
            "nop" -> index++
        }

        if (index == input.size) {
            return acc
        } else if (index > input.size) {
            return -1
        }

        visited[index] += 1
    }
}