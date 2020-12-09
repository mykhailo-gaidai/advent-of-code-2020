import day8.tryFixInstructions
import day9.findEncryptionWeakness
import day9.findFirstInvalidXMASItem
import java.io.File

fun readInput(path: String): List<String> = File("./src/main/kotlin/$path").readLines()

fun main() {
    val input = readInput("day9/input").map(String::toLong)
    findEncryptionWeakness(input, preambleCount = 25)
}