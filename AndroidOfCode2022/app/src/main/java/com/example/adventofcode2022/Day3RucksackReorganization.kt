package com.example.adventofcode2022

class Day3RucksackReorganization(private var input: String): Day() {
    var rucksackContents = getData()

    override fun getData(): List<String> {
        return input.split('\n')
    }

    override fun firstPuzzle(): String {
        val allDuplicateItems = mutableListOf<Char>()
        rucksackContents.forEach { sack ->
            val count = sack.length
            val first = sack.substring(0, count/2)
            val second = sack.substring(count/2, count)
            val sackDuplicates = mutableListOf<Char>()
            first.forEach { item ->
                if (second.contains(item)) {
                    if (!sackDuplicates.contains(item)) {
                        sackDuplicates.add(item)
                        allDuplicateItems.add(item)
                    }
                }
            }
        }
        return priorityScoreItems(allDuplicateItems.joinToString()).toString()
    }

    override fun secondPuzzle(): String {
        var score = 0
        rucksackContents.windowed(3, 3) { group ->
            group[0].forEach { character ->
                if (group[1].contains(character) && group[2].contains(character)) {
                    score += priorityScoreItems(character.toString())
                    return@windowed
                }
            }
        }
        return score.toString()
    }

    private fun priorityScoreItems(items: String): Int {
        var score = 0
        items.forEach { character ->
            score += if (character.code < 91) {
                character.code - 38
            } else {
                character.code - 96
            }
        }
        return score
    }
}