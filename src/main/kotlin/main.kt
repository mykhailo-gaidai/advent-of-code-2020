import day4.isPassportValid
import day4.readPassports
import day5.mapSeat
import java.io.File

fun readInput(path: String): List<String> = File("./src/main/kotlin/$path").readLines()

fun main() {
    readInput("day5/day5_input").map { mapSeat(it.trim()) }
        .filter { it.row in 0..127 && it.column in 0..7 }
        .map { it.id }
        .sorted()
        .windowed(2, 1)
        .onEach { if (it[1] - it[0] > 1) println(it[0] + 1) }
}