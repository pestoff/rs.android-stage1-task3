package subtask2

class Combinator {

    // TODO: Complete the following function
    fun checkChooseFromArray(array: Array<Int>): Int? {
        var result = array.first()
        var n: Long = array.last().toLong()


        var m = n.factorial(result)

        for (i in 0..m) {
            val x = (n-i).factorial() * i.factorial()
            if (x == m)
                return if (i.toInt() == 0) null else i.toInt()
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

fun Long.factorial(test: Int = 1) : Long {
    var isDivided = false
    var result: Long = 1

    for (i in 1..this) {
        result *= i

        if (!isDivided && result.toDouble() % test == 0.toDouble()) {
            isDivided = true
            result = result / test
        }
    }

    return result
}
