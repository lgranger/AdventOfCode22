package com.example.adventofcode2022

class Day2RockPaperScissors(private var input: String): Day() {
    private val encryptedStrategyGuide = getData()

    override fun getData(): List<Any> {
        return input.split('\n')
    }

    override fun firstPuzzle(): String {
        val scoreGuide = mapOf<String, Int>(
            "A X" to 4, "A Y" to 8, "A Z" to 3,
            "B X" to 1, "B Y" to 5, "B Z" to 9,
            "C X" to 7, "C Y" to 2, "C Z" to 6
        )
        var score = 0
        encryptedStrategyGuide.forEach {
            score += scoreGuide[it] ?: 0
        }
        return score.toString()
    }

    override fun secondPuzzle(): String {
        val scoreGuide = mapOf<String, Int>(
            "A X" to 3, "A Y" to 4, "A Z" to 8,
            "B X" to 1, "B Y" to 5, "B Z" to 9,
            "C X" to 2, "C Y" to 6, "C Z" to 7
        )
        var score = 0
        encryptedStrategyGuide.forEach {
            score += scoreGuide[it] ?: 0
        }
        return score.toString()
    }
}