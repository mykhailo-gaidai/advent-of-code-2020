package day7

fun parseBags(rules: List<String>): Map<String, Map<String, Int>> {
    return rules.map { rule ->
        val parts = rule.trim().split(" contain ")

        val root = parts[0]
        val rootColor = root.dropLast(5).trim()

        val contents = parts[1]
        val contentsMap = runCatching {
            contents.split(", ").map { item ->
                val count = item.take(1).toInt()
                val color = item.drop(2)
                    .replace(".", "")
                    .replace("bags", "")
                    .replace("bag", "")
                    .trim()
                color to count
            }.toMap()
        }.getOrElse { emptyMap() }
        rootColor to contentsMap
    }.toMap()
}

fun findColorsThatCanContain(bags: Map<String, Map<String, Int>>, color: String): Set<String> {
    val result = mutableSetOf(color)
    while (true) {
        val newColors = result.flatMap { c -> bags.filter { it.value.containsKey(c) }.keys }.distinct()
        if (result.containsAll(newColors)) break
        result.addAll(newColors)
    }
    return result - color
}

fun calculateRequiredNumberOfBags(bags: Map<String, Map<String, Int>>, color: String): Int {
    return bags[color]!!.entries.sumBy {
        it.value + it.value * calculateRequiredNumberOfBags(bags, it.key)
    }
}