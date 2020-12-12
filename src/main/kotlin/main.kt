import day10.calculateAdapterChain
import day10.calculateNumberOfPermutations
import day11.waitUntilStabilization
import day8.tryFixInstructions
import day9.findEncryptionWeakness
import day9.findFirstInvalidXMASItem
import java.io.File

fun readInput(path: String): List<String> = File("./src/main/kotlin/$path").readLines()

fun main() {
    val input = readInput("day11/input").map { it.trim() }
    val stabilized = waitUntilStabilization(input)
    val occupiedCount = stabilized.sumBy { row -> row.count { it == '#' } }
    println(occupiedCount)
}