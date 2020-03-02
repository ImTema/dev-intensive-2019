package ru.skillbranch.devintensive.utils

import java.util.*

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val list: List<String> = fullName?.split(" ")?:listOf()
        if(list.isEmpty())
            return null to null
        var firstName = list.getOrNull(0)
        var lastName = list.getOrNull(1)


        if (firstName.isNullOrBlank()) {
            firstName = null
        } else if (lastName.isNullOrBlank()) {
            lastName = null
        }
        return firstName to lastName
    }


    fun transliteration(payload: String, devider: String = " "): String {
        var state = ""
        for (i in payload.toLowerCase()) {
            state += when (i.toString().toLowerCase(Locale.getDefault())) {
                "а" -> "a"
                "б" -> "b"
                "в" -> "v"
                "г" -> "g"
                "д" -> "d"
                "е" -> "e"
                "ё" -> "e"
                "ж" -> "zh"
                "з" -> "z"
                "и" -> "i"
                "й" -> "i"
                "к" -> "k"
                "л" -> "l"
                "м" -> "m"
                "н" -> "n"
                "о" -> "o"
                "п" -> "p"
                "р" -> "r"
                "с" -> "s"
                "т" -> "t"
                "у" -> "u"
                "ф" -> "f"
                "х" -> "h"
                "ц" -> "c"
                "ч" -> "ch"
                "ш" -> "sh"
                "щ" -> "sh"
                "ъ" -> ""
                "ы" -> "i"
                "ь" -> ""
                "э" -> "e"
                "ю" -> "yu"
                "я" -> "ya"
                else -> i
            }

        }
        return state.split(" ").joinToString(separator = devider) { it.capitalize() }
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        return if (!firstName.isNullOrBlank() && !lastName.isNullOrBlank())
            firstName[0].toString().toUpperCase() + lastName[0].toString().toUpperCase()
        else if (firstName.isNullOrBlank() && !lastName.isNullOrBlank()) lastName[0].toString().toUpperCase()
        else if (!firstName.isNullOrBlank() && lastName.isNullOrBlank()) firstName[0].toString().toUpperCase()
        else null
    }
}