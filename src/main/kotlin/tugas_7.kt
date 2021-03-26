import java.util.*

fun main(args: Array<String>) {
    println(randomize(arrayOf(8, 23, 1, 2, 2, 13, 12)).contentToString())
    println(minMax(arrayOf(8, 23, 1, 2, 2, 13, 12)).toString())
}

fun removeOne(item: Int, list: List<Int>): List<Int> {
    return list.dropWhile { it == item }
}

fun remove(item: Int, list: List<Int>): List<Int> {
    return list.filterNot { it == item }
}

fun reverse(array: Array<Int>): Array<Int> {
    val midPoint = (array.size / 2) - 1

    for (index in 0..midPoint) {
        val tmp = array[index]
        val reverseIndex = array.size - (1 + index)
        array[index] = array[reverseIndex]
        array[reverseIndex] = tmp
    }
    return array
}

fun randomize(array: Array<Int>): Array<Int> {
    for (i in array.indices) {
        val randomIndex = rand(0, array.size - 1)
        val tmp = array[randomIndex]
        array[randomIndex] = array[i]
        array[i] = tmp
    }
    return array
}

val random = Random()

fun rand(from: Int, to: Int): Int {
    return random.nextInt(to - from) + from
}

fun minMax(numbers: Array<Int>): Pair<Int, Int>? {
    if (numbers.isEmpty()) return null

    var minValue = Integer.MAX_VALUE
    var maxValue = Integer.MIN_VALUE

    for (value in numbers) {
        if (value <= minValue) minValue = value
        if (value >= maxValue) maxValue = value
    }
    return Pair(minValue, maxValue)
}