package day1

class ExpenseReportProcessor(
    val input: List<Int>
) {

    fun find2EntriesThatSumUpTo(target: Int = 2020): Pair<Int, Int> {
        input.forEachIndexed { i, x ->
            input.forEachIndexed { j, y ->
                if (i != j && x + y == target) return x to y
            }
        }
        throw IllegalStateException()
    }

    fun find3EntriesThatSumUpTo(target: Int = 2020): Triple<Int, Int, Int> {
        input.forEachIndexed { i, x ->
            input.forEachIndexed { j, y ->
                input.forEachIndexed { k, z ->
                    if (i != j && i != k && x + y + z == target) return Triple(x, y, z)
                }
            }
        }
        throw IllegalStateException()
    }

}