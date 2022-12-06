package com.example.adventofcode2022

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dayOne()
        dayTwo()
        dayThree()
    }

    private fun dayThree() {
        val rucksackContents = getString(R.string.day_3_input).split('\n')
        dayThreePartOne(rucksackContents)
        dayThreePartTwo(rucksackContents)
    }

    private fun dayThreePartOne(rucksackContents: List<String>) {
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
        val score = priorityScoreItems(allDuplicateItems.joinToString())
        val dayTwoFirstAnswer: TextView = findViewById(R.id.day_three_first_answer)
        dayTwoFirstAnswer.text = score.toString()
    }

    private fun dayThreePartTwo(rucksackContents: List<String>) {
        var score = 0
        rucksackContents.windowed(3, 3) { group ->
            group[0].forEach { character ->
                if (group[1].contains(character) && group[2].contains(character)) {
                    score += priorityScoreItems(character.toString())
                    return@windowed
                }
            }
        }
        val dayThreeSecondAnswer: TextView = findViewById(R.id.day_three_second_answer)
        dayThreeSecondAnswer.text = score.toString()
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

    private fun dayTwo() {
       val  encryptedStrategyGuide: List<String> = getString(R.string.day_2_input).split('\n')
        dayTwoPartOne(encryptedStrategyGuide)
        dayTwoPartTwo(encryptedStrategyGuide)
    }

    private fun dayTwoPartOne(encryptedStrategyGuide: List<String>) {
        val scoreGuide = mapOf<String, Int>(
            "A X" to 4, "A Y" to 8, "A Z" to 3,
            "B X" to 1, "B Y" to 5, "B Z" to 9,
            "C X" to 7, "C Y" to 2, "C Z" to 6
        )
        var score = 0
        encryptedStrategyGuide.forEach {
            score += scoreGuide[it] ?: 0
        }
        val dayTwoFirstAnswer: TextView = findViewById(R.id.day_two_first_answer)
        dayTwoFirstAnswer.text = score.toString()
    }

    private fun dayTwoPartTwo(encryptedStrategyGuide: List<String>) {
        val scoreGuide = mapOf<String, Int>(
            "A X" to 3, "A Y" to 4, "A Z" to 8,
            "B X" to 1, "B Y" to 5, "B Z" to 9,
            "C X" to 2, "C Y" to 6, "C Z" to 7
        )
        var score = 0
        encryptedStrategyGuide.forEach {
            score += scoreGuide[it] ?: 0
        }
        val dayTwoSecondAnswer: TextView = findViewById(R.id.day_two_second_answer)
        dayTwoSecondAnswer.text = score.toString()
    }

    private fun dayOne() {
        val elfCalories = getDayOneData()
        dayOnePartOne(elfCalories)
        dayOnePartTwo(elfCalories)
    }

    private fun getDayOneData(): List<Int> {
        val allElfCalories = getString(R.string.day_1_input)
            .split('\n')
            .map { it.toIntOrNull() }

        val calorieTotalsByElf = mutableListOf<Int>()
        var calorieTotal = 0
        allElfCalories.forEach { cal ->
            if (cal == null) {
                calorieTotalsByElf.add(calorieTotal)
                calorieTotal = 0
            } else {
                calorieTotal += cal
            }
        }
        calorieTotalsByElf.add(calorieTotal)
        return calorieTotalsByElf
    }

    private fun dayOnePartOne(elfCalories: List<Int>) {
        val dayOneFirstAnswer: TextView = findViewById(R.id.day_one_first_answer)
        dayOneFirstAnswer.text = elfCalories.maxOrNull().toString()
    }

    private fun dayOnePartTwo(elfCalories: List<Int>) {
        val topThreeTotalCalories = elfCalories.sortedDescending().subList(0,3).sum()

        val dayOneSecondAnswer: TextView = findViewById(R.id.day_one_second_answer)
        dayOneSecondAnswer.text = topThreeTotalCalories.toString()
    }
}