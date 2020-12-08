import day8.tryFixInstructions
import java.io.File

fun readInput(path: String): List<String> = File("./src/main/kotlin/$path").readLines()

fun main() {
//    val input = readInput("day8/day8_test")
    val input = readInput("day8/day8_input")
    tryFixInstructions(input)
}