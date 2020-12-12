package day12

enum class Direction {
    East, South, West, North
}

fun moveShip(input: List<String>): Pair<Int, Int> {
    var waypoint = 10 to -1
    var position = 0 to 0
    input.forEach {
        val instr = it.first()
        val distance = it.drop(1).trim().toInt()

        when (instr) {
            'N' -> waypoint = waypoint.first to (waypoint.second - distance)
            'S' -> waypoint = waypoint.first to (waypoint.second + distance)
            'E' -> waypoint = (waypoint.first + distance) to waypoint.second
            'W' -> waypoint = (waypoint.first - distance) to waypoint.second
            'R' -> waypoint = when (distance) {
                90 -> -waypoint.second to waypoint.first
                180 -> -waypoint.first to -waypoint.second
                270 -> waypoint.second to -waypoint.first
                else -> TODO()
            }
            'L' -> waypoint = when (distance) {
                90 -> waypoint.second to -waypoint.first
                180 -> -waypoint.first to -waypoint.second
                270 -> -waypoint.second to waypoint.first
                else -> TODO()
            }
            'F' -> position = (position.first + waypoint.first * distance) to (position.second + waypoint.second * distance)
            else -> TODO()
        }

        println("$it -> $position, $waypoint")
    }

    return position
}

