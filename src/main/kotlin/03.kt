import java.io.File

fun main() {
    val inputFileName = "src/main/resources/03.txt"

    val prioritiesSum = File(inputFileName).readLines().sumOf { line ->
        val rucksackItems = line.map(::Item)
        val rucksackSize = rucksackItems.size

        val firstCompartment = rucksackItems.subList(0, rucksackSize / 2)
        val secondCompartment = rucksackItems.subList(rucksackSize / 2, rucksackSize)

        val commonItemInBothCompartments = firstCompartment.intersect(secondCompartment.toSet()).firstOrNull()
        commonItemInBothCompartments?.priority ?: 0
    }

    println(prioritiesSum)
}

data class Item(val type: Char) {
    val priority: Int = when {
        type.isLowerCase() -> type - 96
        type.isUpperCase() -> type - 38
        else -> error("Unsupported character")
    }.code
}
