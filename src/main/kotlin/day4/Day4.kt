package day4

fun readPassports(input: List<String>): List<Map<String, String>> {
    val passports = mutableListOf<Map<String, String>>()
    var passport = mutableMapOf<String, String>()
    input.forEach { string ->
        if (string.trim().isEmpty()) {
            passports.add(passport)
            passport = mutableMapOf()
        } else {
            string.trim().split(' ').forEach {
                val split = it.split(':')
                val key = split[0].trim()
                val value = split[1].trim()
                passport[key] = value
            }
        }
    }
    passports.add(passport)

    return passports
}

fun isPassportValid(passport: Map<String, String>): Boolean {
    val isHeightValid = passport["hgt"]?.let {
        val unit = it.takeLast(2)
        val value = it.dropLast(2).toIntOrNull()
        return@let when (unit) {
            "cm" -> value in 150.rangeTo(193)
            "in" -> value in 59.rangeTo(76)
            else -> false
        }
    } ?: false
    val isHairColorValid = passport["hcl"]?.let { color ->
        color.getOrNull(0) == '#' && color.drop(1).all { it in '0'.rangeTo('9') || it in 'a'.rangeTo('f') }
    } ?: false
    val isEyeColorValid = passport["ecl"] in listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")
    val isPidValid = passport["pid"]?.length == 9 && (passport["pid"]?.all { it.isDigit() } ?: false)
    val isBirthYearValid = passport.get("byr")?.toIntOrNull() in 1920.rangeTo(2002)
    val isIssueYearValid = passport["iyr"]?.toIntOrNull() in 2010.rangeTo(2020)
    val isExpirationYearValid = passport["eyr"]?.toIntOrNull() in 2020.rangeTo(2030)

    val result = (isBirthYearValid
            && isIssueYearValid
            && isExpirationYearValid
            && isHeightValid
            && isHairColorValid
            && isEyeColorValid
            && isPidValid)
    if (result) {
        println("$passport => $isBirthYearValid, $isIssueYearValid, $isExpirationYearValid, $isHeightValid, $isHairColorValid, $isEyeColorValid, $isPidValid")
    }
    return result


}