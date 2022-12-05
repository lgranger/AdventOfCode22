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