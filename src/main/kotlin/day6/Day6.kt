package day6

fun groupAnswers(input: List<String>): List<String> {
    val groups = mutableListOf<String>()
    val group = mutableListOf<String>()
    input.forEach { person ->
        if (person.trim().isEmpty()) {
            val groupString = group.flatMap { it.toList() }
                .groupBy { it }
                .filter { it.value.size == group.size }
                .map { it.key }
                .joinToString(separator = "")
            groups.add(groupString)
            group.clear()
        } else {
            group.add(person)
        }
    }

    val groupString = group.flatMap { it.toList() }
        .groupBy { it }
        .filter { it.value.size == group.size }
        .map { it.key }
        .joinToString(separator = "")
    groups.add(groupString)

    return groups
}