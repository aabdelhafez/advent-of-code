import java.io.File

typealias Rucksack = List<Item>

fun main() {
    val inputFileName = "src/main/resources/03.txt"

    val rucksacks: List<Rucksack> = File(inputFileName).readLines().map { line -> line.map(::Item) }
    val rucksackChunks: List<List<Rucksack>> = rucksacks.chunked(3)

    val commonItemForEveryRucksackChunk: List<Item?> =
        rucksackChunks.map { (firstRucksack, secondRucksack, thirdRucksack) ->
            firstRucksack.intersect(secondRucksack.toSet()).intersect(thirdRucksack.toSet()).firstOrNull()
        }
    val sumOfPrioritiesOfCommonItemForEveryRucksackChunk: Int = commonItemForEveryRucksackChunk.sumOf {
        it?.priority ?: 0
    }

    println(sumOfPrioritiesOfCommonItemForEveryRucksackChunk)
}

data class Item(val type: Char) {
    val priority: Int = when {
        type.isLowerCase() -> type - 96
        type.isUpperCase() -> type - 38
        else -> error("Unsupported character")
    }.code
}
