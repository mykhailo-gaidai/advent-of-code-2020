import day4.isPassportValid
import day4.readPassports
import day5.mapSeat
import day6.groupAnswers
import java.io.File

fun readInput(path: String): List<String> = File("./src/main/kotlin/$path").readLines()

fun main() {
    val input = readInput("day6/day6_input")
    val totalAnswers = groupAnswers(input).onEach {
        println(it)
    }.sumBy { it.length }
    println(totalAnswers)

}