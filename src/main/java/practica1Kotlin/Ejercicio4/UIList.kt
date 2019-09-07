package practica1Kotlin.Ejercicio4

import kotlin.math.pow

class UIList {
    fun isSorted(numList: List<Int>): Boolean {
        return numList == numList.sorted() || numList == numList.sortedDescending()
//        return numList.zipWithNext().all { it.first <= it.second } ||
//                numList.zipWithNext().all { it.first >= it.second }
    }

    fun sortList(numListDisordered: List<Int>, ascOrder: Boolean): List<Int> {
        return if (ascOrder) numListDisordered.sorted() else numListDisordered.sortedDescending()
    }

    fun filterPrimes(numListDisordered: List<Int>): List<Int> {
        var res = ArrayList<Int>()
        outer@ for (n in numListDisordered) {
            if (n > 1) {
                for (d in 2 until n) {
                    if (n % d == 0) continue@outer
                }
                println("$n is prime")
                res.add(n)
            }
        }
        return res.sorted()
    }

    fun powMap(numListAsc: List<Int>): List<Int> {
        var res = ArrayList<Int>()
        for (n in numListAsc) {
            res.add(n `**` 2)  // res.add(n.toDouble().pow(2).toInt())
        }
        return res
    }

    infix fun Int.`**`(n: Int): Int = toDouble().pow(n).toInt()

    fun sumProdPos(numListAsc: List<Int>): Int {
        var sum = 0
        numListAsc.forEachIndexed { index, num -> sum += (index+1) * num }
//        for ((index, num) in numListAsc.withIndex()) { sum += (index+1) * num }
        return sum
    }

}
