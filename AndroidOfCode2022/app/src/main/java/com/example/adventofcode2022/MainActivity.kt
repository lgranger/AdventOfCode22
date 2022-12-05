package com.example.adventofcode2022

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dayOne()
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