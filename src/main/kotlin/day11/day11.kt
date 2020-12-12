package day11

fun waitUntilStabilization(input: List<String>): List<String> {
    var currentInput = input
    var seatChanged = true
    var step = 0
    while(seatChanged) {
        seatChanged = false
        val newInput = currentInput.mapIndexed {rowIndex, row ->
            row.mapIndexed { columnIndex, column ->
                val newState = getNewSeatState(currentInput, rowIndex, columnIndex)
                if (newState != column && !seatChanged) {
                    seatChanged = true
                }
                newState
            }.joinToString(separator = "")
        }

        println()
        println("step #${step++}")
        newInput.forEach {
            println(it)
        }

        currentInput = newInput
    }
    return currentInput
}

fun getNewSeatState(input: List<String>, row: Int, column: Int): Char {
    val currentState = input[row][column]
    if (currentState == '.') return currentState

    val visibleOccupiedSeats = countVisibleOccupiedSeats(input, row, column)

    return if (currentState == 'L' && visibleOccupiedSeats == 0) '#'
    else if (currentState == '#' && visibleOccupiedSeats >= 5) 'L'
    else currentState
}

fun countVisibleOccupiedSeats(input: List<String>, row: Int, column: Int): Int {
    val visibleSeats = listOf(
        getFirstVisibleSeat(input, row, column, -1, -1),
        getFirstVisibleSeat(input, row, column, 0, -1),
        getFirstVisibleSeat(input, row, column, 1, -1),
        getFirstVisibleSeat(input, row, column, 1, 0),
        getFirstVisibleSeat(input, row, column, 1, 1),
        getFirstVisibleSeat(input, row, column, 0, 1),
        getFirstVisibleSeat(input, row, column, -1, 1),
        getFirstVisibleSeat(input, row, column, -1, 0),
    )
    val count = visibleSeats.count { it == '#' }
    return count
}

fun getFirstVisibleSeat(input: List<String>, row: Int, column: Int, rowDelta: Int, columnDelta: Int): Char {
    var r = row + rowDelta
    var c = column + columnDelta
    while (input.getOrNull(r)?.getOrNull(c) == '.') {
        r += rowDelta
        c += columnDelta
    }
    return input.getOrNull(r)?.getOrNull(c) ?: 'L'
}

fun countAdjacentOccupiedSeats(input: List<String>, row: Int, column: Int): Int {
    val adjacentSeats = listOf(
        input.getOrNull(row)?.getOrNull(column - 1) ?: 'L',
        input.getOrNull(row)?.getOrNull(column + 1) ?: 'L',
        input.getOrNull(row - 1)?.getOrNull(column - 1) ?: 'L',
        input.getOrNull(row - 1)?.getOrNull(column) ?: 'L',
        input.getOrNull(row - 1)?.getOrNull(column + 1) ?: 'L',
        input.getOrNull(row + 1)?.getOrNull(column - 1) ?: 'L',
        input.getOrNull(row + 1)?.getOrNull(column) ?: 'L',
        input.getOrNull(row + 1)?.getOrNull(column + 1) ?: 'L',
    )

    val count = adjacentSeats.count { it == '#' }
    return count
}