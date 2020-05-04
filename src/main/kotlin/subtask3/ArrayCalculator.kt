package subtask3

class ArrayCalculator {
    
    fun maxProductOf(numberOfItems: Int, itemsFromArray: Array<Any>): Int {

        val validArray = filterArray(itemsFromArray)
        validArray.sort()

        if (validArray.isEmpty()) return 0

        if (numberOfItems > validArray.size) {
            var result = 1
            validArray.forEach { result *= it }

            return result
        }

        return test2(numberOfItems, validArray.toMutableList())
    }

    fun filterArray(items: Array<Any>) : Array<Int> {

        var result = emptyList<Int>().toMutableList()

        items.forEach { if (it is Int) result.add(it) }

        return result.toTypedArray()
    }

    fun test2(numberOfItems: Int, items: MutableList<Int>) : Int {

        if (numberOfItems == 0) {
            return 1
        }
        if (numberOfItems == 1) {
            return items.max() ?: 1
        } else {
            val tempArray = items
            val negativeCount = tempArray.count { it < 0 }
            val positiveProduct = tempArray[tempArray.size - 1] * tempArray[tempArray.size - 2]

            if (negativeCount >= 2) {
                val negativeProduct = tempArray[0] * tempArray[1]

                if (negativeProduct > positiveProduct) {

                    tempArray.removeAt(0)
                    tempArray.removeAt(0)
                    return negativeProduct * test2(numberOfItems - 2, tempArray)
                }
            }

            tempArray.removeAt(tempArray.size - 1)
            tempArray.removeAt(tempArray.size - 1)
            return positiveProduct * test2(numberOfItems - 2, tempArray)
        }
    }



    fun test1(numberOfItems: Int, items: MutableList<Int>) : MutableList<Int> {

        if (numberOfItems == 1) {
            return mutableListOf(items.min() ?: 1 , items.max() ?: 1)
        }

        val temporal = items
        val max = items.max() ?: 1
        val min = items.min() ?: 1

        temporal.remove(max)
        temporal.remove(min)

        val previousResult = test1(numberOfItems -1, temporal)

        return mutableListOf(
            Math.min(min * previousResult.first(), min * previousResult.last()),
            Math.max(max * previousResult.first(), max * previousResult.last())
        )
    }
}
