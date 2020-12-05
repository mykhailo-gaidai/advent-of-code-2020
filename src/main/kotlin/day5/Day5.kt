package day5


fun mapSeat(input: String): SeatData {
    val row = Integer.parseInt(input.take(7).map { if (it == 'F') '0' else '1' }.joinToString(separator = ""), 2)
    val column =
        Integer.parseInt(input.takeLast(3).map { if (it == 'R') '1' else '0' }.joinToString(separator = ""), 2)
    val id = row * 8 + column
    return SeatData(row, column, id)
}

data class SeatData(
    val row: Int,
    val column: Int,
    val id: Int
)