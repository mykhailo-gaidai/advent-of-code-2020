import day7.calculateRequiredNumberOfBags
import day7.parseBags
import java.io.File

fun readInput(path: String): List<String> = File("./src/main/kotlin/$path").readLines()

fun main() {
//    val input = readInput("day7/day7_test")
//    val input = readInput("day7/day7_test2")
    val input = readInput("day7/day7_input")
    val bags = parseBags(input)
    val requiredNumberOfBags = calculateRequiredNumberOfBags(bags, "shiny gold")
    println(requiredNumberOfBags)
}