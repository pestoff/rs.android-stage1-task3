package subtask5

import java.lang.NumberFormatException
import kotlin.reflect.KClass

class TelephoneFinder {

    // TODO: Complete the following function
    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {

        try {
            val test = number.toInt()

            if (test < 0) return null

            val output = mutableListOf<String>()

            for ((index, element) in number.toCharArray().withIndex()) {
                for (neighbour in getNeighbour(element)) {
                    val temp = number.toCharArray()
                    temp[index] = neighbour
                    output.add(temp.joinToString(""))
                }
            }

            return output.toTypedArray()

        } catch (e: NumberFormatException) {
            return null
        }
    }

    fun getNeighbour(number: Char) : Array<Char> {
        return when(number) {
            '1' -> arrayOf('2', '4')
            '2' -> arrayOf('1', '5', '3')
            '3' -> arrayOf('2', '6')
            '4' -> arrayOf('1', '5', '7')
            '5' -> arrayOf('2', '4', '6', '8')
            '6' -> arrayOf('3', '5', '9')
            '7' -> arrayOf('4', '8')
            '8' -> arrayOf('0', '5', '7', '9')
            '9' -> arrayOf('6', '8')
            else -> arrayOf('8')
        }
    }
}
