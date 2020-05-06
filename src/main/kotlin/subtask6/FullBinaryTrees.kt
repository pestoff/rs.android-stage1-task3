package subtask6

import java.util.*

class FullBinaryTrees {

    // TODO: Complete the following function
    fun stringForNodeCount(count: Int): String {

        val test = allPossibleFBT(count)
        val output = mutableListOf<String>()

        if (test.isEmpty()) return "[]"

        for (element in test) {
            output.add(breath(element))
        }

        return output.joinToString(prefix = "[", postfix = "]", separator = ",")
    }
}

fun allPossibleFBT(N: Int) : MutableList<TreeNode> {
    if (N % 2 == 0) return mutableListOf<TreeNode>()

    val res = mutableListOf<TreeNode>()

    if (N == 1) {
        res.add(TreeNode(0))
        return res
    }

    for (i in 1..N-1 step 2) {
        val leftSubTrees = allPossibleFBT(i)
        val rightSubTrees = allPossibleFBT(N - i -1)
        for (left in leftSubTrees)
            for (right in rightSubTrees) {
                var root = TreeNode(0)
                root.left = left
                root.right = right
                res.add(root)
            }
    }

    return res
}

val queue = ArrayDeque<TreeNode>()

fun breath(root: TreeNode?) : String {

    var output = mutableListOf<String>()

    if (root == null)
        return ""
    queue.clear()
    queue.add(root)
    while (!queue.isEmpty()) {
        val node = queue.remove()

        if (node.value == 1){
            output.add("null")
            continue
        }

        output.add(node.value.toString())
        if (node.left != null) queue.add(node.left) else queue.add(TreeNode(1))
        if (node.right != null) queue.add(node.right) else queue.add(TreeNode(1))
    }

    output.reverse()
    while (output.first() == "null") {
        output.removeAt(0)
    }
    output.reverse()

    return output.joinToString(prefix = "[", postfix = "]", separator = ",")
}


class TreeNode(var value: Int) {
         var left: TreeNode? = null
         var right: TreeNode? = null
}



