import java.io.File
import kotlin.math.max

fun main() {
    val inputFilePath = "src/main/resources/01.txt"

    var globalMaximumSoFar = 0
    var localMaximumSoFar = 0

    File(inputFilePath).forEachLine { line ->
        if (line.isBlank()) {
            globalMaximumSoFar = max(globalMaximumSoFar, localMaximumSoFar)
            localMaximumSoFar = 0
        } else {
            val currentValue = line.toIntOrNull() ?: 0
            localMaximumSoFar += currentValue
        }
    }

    println(globalMaximumSoFar)
}
