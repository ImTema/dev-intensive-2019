package ru.skillbranch.devintensive.extensions

import java.lang.Math.abs
import java.text.SimpleDateFormat
import java.util.*

enum class TimeUnits(var value: Long) {
    SECOND(1000L),
    MINUTE(SECOND.value * 60),
    HOUR(MINUTE.value * 60),
    DAY(HOUR.value * 24)
}

fun Date.format(pattern: String = "HH:mm:ss dd.MM.yy"): String {
    return SimpleDateFormat(pattern, Locale("ru")).format(this)
}

fun Date.add(value: Int, units: TimeUnits = TimeUnits.SECOND): Date {
    this.time += value * units.value
    return this
}

fun Date.humanizeDiff(date : Date = Date()):String {
    val timeNow = this.time
//var timeNow = Date().add(3,TimeUnits.HOUR).time

    val time = (timeNow-date.time) / 1000
    val state = when (time) {
        in 0..1 -> "только что"
        in 1..45 -> "через несколько секунд"
        in 45..75 -> "через минуту"
        in 75..45*60 -> "через ${time/ 60} минут "
        in 45*60..75*60 -> "через час"
        in 75*60..22*60*60  -> "через ${time/60/60} часов"
        in 22*60*60..26* 60*60  ->  "через день"
        in 22*60*60..360* 60*60 -> "более чем ${kotlin.math.abs(time / 60 / 60 / 24)} дней назад"
        in 360*60*60..Long.MAX_VALUE -> "более чем ${time/ 60/60/24} дней назад"
        in -1..0 -> "только что"
        in -45..-1 -> "несколько секунд назад"
        in -75..-45 -> "минуту назад"
        in -45*60..-75 -> "${kotlin.math.abs(time / 60)} минут назад"
        in -75*60..-45* 60 -> "час назад"
        in -22* 60*60..-75* 60  -> "${kotlin.math.abs(time / 60 / 60)} часа назад"
        in  -26* 60*60..-22*60*24  ->  "день назад"
        in -360* 60*60..-22* 60*60 -> "${kotlin.math.abs(time/ 60/60/24)} дней назад"
        else -> "более года назад"
    }
    return state
}
