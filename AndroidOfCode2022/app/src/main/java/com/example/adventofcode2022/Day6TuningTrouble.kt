package com.example.adventofcode2022

class Day6TuningTrouble(var input: String): Day() {
    val signal: List<Char> = getData()
    override fun getData(): List<Char> {
        return input.toList()
    }

    override fun firstPuzzle(): String {
        return findCodeStart(4)
    }

    override fun secondPuzzle(): String {
        return findCodeStart(14)
    }

    private fun findCodeStart(codeLength: Int): String {
        val code = signal.windowed(codeLength, 1).takeWhile { it.distinct().count() != codeLength }
        return (code.count() + codeLength).toString()
    }
}