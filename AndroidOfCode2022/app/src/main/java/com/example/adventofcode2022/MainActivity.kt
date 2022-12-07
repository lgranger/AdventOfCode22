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

    private fun dayOne() {
        val dayOneFirstAnswer: TextView = findViewById(R.id.day_one_first_answer)
        val dayOneSecondAnswer: TextView = findViewById(R.id.day_one_second_answer)

        val dayOne = Day1CalorieCounting(getString(R.string.day_1_input))
        dayOneFirstAnswer.text = dayOne.firstPuzzle()
        dayOneSecondAnswer.text = dayOne.secondPuzzle()
    }

    private fun dayTwo() {
        val dayTwoFirstAnswer: TextView = findViewById(R.id.day_two_first_answer)
        val dayTwoSecondAnswer: TextView = findViewById(R.id.day_two_second_answer)

        val dayTwo = Day2RockPaperScissors(getString(R.string.day_2_input))
        dayTwoFirstAnswer.text = dayTwo.firstPuzzle()
        dayTwoSecondAnswer.text = dayTwo.secondPuzzle()
    }

    private fun dayThree() {
        val dayThreeFirstAnswer: TextView = findViewById(R.id.day_three_first_answer)
        val dayThreeSecondAnswer: TextView = findViewById(R.id.day_three_second_answer)

        val dayThree = Day3RucksackReorganization(getString(R.string.day_3_input))
        dayThreeFirstAnswer.text = dayThree.firstPuzzle()
        dayThreeSecondAnswer.text = dayThree.secondPuzzle()
    }

}