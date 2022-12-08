import java.io.File
import java.util.PriorityQueue

fun main() {
    val inputFilePath = "src/main/resources/01.txt"

    val localSums = PriorityQueue<Int>(compareByDescending { it })
    var localSumSoFar = 0

    File(inputFilePath).forEachLine { line ->
        if (line.isBlank()) {
            localSums.add(localSumSoFar)
            localSumSoFar = 0
        } else {
            val currentValue = line.toIntOrNull() ?: 0
            localSumSoFar += currentValue
        }
    }

    val maximumLocalSums = listOf(localSums.poll(), localSums.poll(), localSums.poll())

    println("Maximum local sum: ${maximumLocalSums.firstOrNull()}")
    println("Sum of three maximum local sums: ${maximumLocalSums.sum()}")
}
