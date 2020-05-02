package subtask1

import kotlin.math.absoluteValue

class PolynomialConverter {

    fun convertToStringFrom(numbers: Array<Int>): String? {

        var result = ""

        for ((index, element) in numbers.withIndex()) {

            if (element == 0) continue

            if (index == 0)
                result += "${element}x^${numbers.size - 1}"
            else {
                val symbol = if (element >= 0) "+" else "-"
                val number = if (element.absoluteValue != 1) "${element.absoluteValue}" else ""
                val degree = when {
                    numbers.size - (index + 1) == 0 -> ""
                    numbers.size - (index + 1) == 1 -> "x"
                    else -> "x^${numbers.size - (index + 1)}"
                }

                result += " $symbol $number$degree"
            }
        }

        return if (result == "") null else result
    }
}
