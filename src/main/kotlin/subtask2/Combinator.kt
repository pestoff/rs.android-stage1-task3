package subtask2

class Combinator {

    // TODO: Complete the following function
    fun checkChooseFromArray(array: Array<Int>): Int? {
        var result = array.first()
        var n: Long = array.last().toLong()


        var m = n.factorial() / result

        for (i in 0..m) {
            val x = (n-i).factorial() * i.factorial()
            if (x == m)
                return i.toInt()
        }

        return null
    }
}

fun Int.factorial() : Int {
    var result = 1

    for (i in 1..this) {
        result *= i
    }

    return result
}

fun Long.factorial() : Long {
    var result: Long = 1

    for (i in 1..this) {
        result *= i
    }

    return result
}
