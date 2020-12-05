package day2

fun getValidPasswords(input: List<String>): List<String> =
    input.filter { inputString ->
        val split = inputString.split(':')
        val (letter, first, last) = split[0].split(' ').run {
            val numbers = get(0).split('-').map { it.toInt() }
            PasswordRule(get(1).first(), numbers[0], numbers[1])
        }
        val password = split[1]
        val firstLetter = password.getOrNull(first)
        val secondLetter = password.getOrNull(last)
        val result = if (firstLetter == letter && secondLetter == letter)
            false
        else
            firstLetter == letter || secondLetter == letter
        println("$inputString, $firstLetter - $secondLetter = $result")
        result
    }

data class PasswordRule(
    val letter: Char,
    val first: Int,
    val last: Int
)