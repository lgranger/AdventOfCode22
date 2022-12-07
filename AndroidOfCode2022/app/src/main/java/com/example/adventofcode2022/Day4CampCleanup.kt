package com.example.adventofcode2022

class Day4CampCleanup(private val input: String): Day() {
    val sectionAssignments = getData()

    override fun getData(): List<Pair<IntRange, IntRange>> {
        val rangedSectionAssignments: MutableList<Pair<IntRange, IntRange>> = mutableListOf()
        input.split('\n', ',', '-').windowed(4,4).forEach { it ->
            val firstElf = it[0].toInt() ..it[1].toInt()
            val secondElf = it[2].toInt()..it[3].toInt()
            rangedSectionAssignments.add(Pair(firstElf, secondElf))
        }
        return rangedSectionAssignments
    }

    override fun firstPuzzle(): String {
        var count = 0
        sectionAssignments.forEach { pair ->
            val firstElf = pair.first
            val secondElf = pair.second
            if ((firstElf.contains(secondElf.first) && firstElf.contains(secondElf.last))
             || (secondElf.contains(firstElf.first) && secondElf.contains(firstElf.last))) {
                count += 1
            }
        }
        return count.toString()
    }

    override fun secondPuzzle(): String {
        var count = 0
        sectionAssignments.forEach { pair ->
            val firstElf = pair.first
            val secondElf = pair.second
            if ((firstElf.contains(secondElf.first) && firstElf.contains(secondElf.last)) ||
                (secondElf.contains(firstElf.first) && secondElf.contains(firstElf.last)) ||
                ((firstElf.first >= secondElf.first) && (firstElf.first <= secondElf.last)) ||
                ((secondElf.first >= firstElf.first) && (secondElf.first <= firstElf.last)))
            {
                count += 1
            }
        }
        return count.toString()
    }
}