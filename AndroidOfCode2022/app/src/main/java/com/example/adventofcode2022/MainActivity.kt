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
        dayFour()
        dayFive()
        daySix()
        daySeven()
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

    private fun dayFour() {
        val dayFourFirstAnswer: TextView = findViewById(R.id.day_four_first_answer)
        val dayFourSecondAnswer: TextView = findViewById(R.id.day_four_second_answer)

        val dayFour = Day4CampCleanup(getString(R.string.day_4_input))
        dayFourFirstAnswer.text = dayFour.firstPuzzle()
        dayFourSecondAnswer.text = dayFour.secondPuzzle()
    }

    private fun dayFive() {
        val dayFiveFirstAnswer: TextView = findViewById(R.id.day_five_first_answer)
        val dayFiveSecondAnswer: TextView = findViewById(R.id.day_five_second_answer)

        val dayFive = Day5SupplyStacks(getString(R.string.day_5_input))
        dayFiveFirstAnswer.text = dayFive.firstPuzzle()
        dayFiveSecondAnswer.text = dayFive.secondPuzzle()
    }

    private fun daySix() {
        val daySixFirstAnswer: TextView = findViewById(R.id.day_six_first_answer)
        val daySixSecondAnswer: TextView = findViewById(R.id.day_six_second_answer)

        val daySix = Day6TuningTrouble(getString(R.string.day_6_input))
        daySixFirstAnswer.text = daySix.firstPuzzle()
        daySixSecondAnswer.text = daySix.secondPuzzle()
    }

    private fun daySeven() {
        val daySevenFirstAnswer: TextView = findViewById(R.id.day_seven_first_answer)
        val daySevenSecondAnswer: TextView = findViewById(R.id.day_seven_second_answer)

        val daySeven = Day7NoSpaceLeftOnDevice(getString(R.string.day_7_input))
        daySevenFirstAnswer.text = daySeven.firstPuzzle()
        daySevenSecondAnswer.text = daySeven.secondPuzzle()
    }
}