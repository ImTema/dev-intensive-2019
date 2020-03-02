package ru.skillbranch.devintensive.extensions

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

fun Date.humanizeDiff(date : Date = Date()) {
    val currentTime = date.time
    val thatTime = this.time
    val diff = thatTime - currentTime
    if(diff > 0) {
        print("more")
        //более
    }else{
        print("less")
        //назад
    }
}
