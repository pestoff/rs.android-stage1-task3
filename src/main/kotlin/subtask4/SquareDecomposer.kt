package subtask4

import kotlin.math.sqrt

class SquareDecomposer {

    // TODO: Complete the following function
    fun decomposeNumber(number: Int): Array<Int>? {

        if (number < 4) return null

        val differnce = (number - (number - 1)) * (number + (number -1))
        val output = langrange(differnce)

        output.add(output.size, number - 1)

        return output.toTypedArray()
    }


    fun langrange(input: Int): MutableList<Int> {
        val output = mutableListOf<Int>()

        val sqrtInput = input.sqrt()

        for (i in sqrtInput downTo 1) {
            if (i.sqr() == input) {
                output.add(i)
                return output
            }

            for (j in i-1 downTo 1) {
                if (i.sqr() + j.sqr() == input) {
                    output.addAll(arrayOf(j, i))
                    return output
                }

                for (k in j-1 downTo 1) {
                    if (i.sqr() + j.sqr() + k.sqr() == input) {
                        output.addAll(arrayOf(j, i, k))
                        return output
                    }

                    for (m in k-1 downTo 1) {
                        val temp = i.sqr() + j.sqr() + k.sqr() + m.sqr()
                        if (temp == input) {
                            val array = arrayOf(m, k, j, i)
                            output.addAll(array)
                            return output

                        }
                    }
                }
            }
        }

        return output
    }

    fun Int.sqr() = this * this

    fun Int.sqrt() = sqrt(this.toDouble()).toInt()





}
