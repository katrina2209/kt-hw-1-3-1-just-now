fun main() {
    var numberOfSeconds = 22
    println("Был(а) ${agoToText(numberOfSeconds)}")
    numberOfSeconds = 22 * 60
    println("Был(а) ${agoToText(numberOfSeconds)}")
    numberOfSeconds = 21 * 60 * 60
    println("Был(а) ${agoToText(numberOfSeconds)}")
    numberOfSeconds = 24 * 60 * 60 + 152
    println("Был(а) ${agoToText(numberOfSeconds)}")
    numberOfSeconds = 48 * 60 * 60 + 15
    println("Был(а) ${agoToText(numberOfSeconds)}")
    numberOfSeconds = 72 * 60 * 60 + 100500
    println("Был(а) ${agoToText(numberOfSeconds)}")
}

fun agoToText(numberOfSeconds: Int): String {
    return when (numberOfSeconds) {
        in 0..60 -> "только что"
        in 61..60 * 60 -> "${numberOfSeconds / 60} ${minutesToText(numberOfSeconds)} назад"
        in 60 * 60 + 1..24 * 60 * 60 -> "${numberOfSeconds / 60 / 60} ${hoursToText(numberOfSeconds)} назад"
        in 24 * 60 * 60 + 1..48 * 60 * 60 -> "сегодня"
        in 48 * 60 * 60 + 1..72 * 60 * 60 -> "вчера"
        in 72 * 60 * 60 + 1..Int.MAX_VALUE -> "давно"
        else -> "не был(а)"
    }
}

fun minutesToText(numberOfSeconds: Int): String {
    val minutes = numberOfSeconds / 60
    return when {
        minutes == 1 || minutes % 10 == 1 && minutes != 11 -> "минуту"
        minutes in 2..4 || minutes % 10 in 2..4 -> "минуты"
        else -> "минут"
    }
}

fun hoursToText(numberOfSeconds: Int): String {
    val hours = numberOfSeconds / 60 / 60
    return when {
        hours == 1 || hours % 10 == 1 && hours != 11 -> "час"
        hours in 2..4 || hours % 10 in 2..4 -> "часа"
        else -> "часов"
    }
}