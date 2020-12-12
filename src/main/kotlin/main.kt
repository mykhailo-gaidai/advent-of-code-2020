import day10.calculateAdapterChain
import day10.calculateNumberOfPermutations
import day11.waitUntilStabilization
import day12.moveShip
import day8.tryFixInstructions
import day9.findEncryptionWeakness
import day9.findFirstInvalidXMASItem
import java.io.File
import kotlin.math.abs

fun readInput(path: String): List<String> = File("./src/main/kotlin/$path").readLines()

fun main() {
    val input = readInput("day12/input")
    val (x, y) = moveShip(input)
    println(abs(x) + abs(y))
}