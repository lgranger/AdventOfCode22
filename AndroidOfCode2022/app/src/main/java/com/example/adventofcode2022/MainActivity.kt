package com.example.adventofcode2022

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dayOnePartOne()
    }

    fun dayOnePartOne() {
        val elfCalories = getString(R.string.day_1_input).split('\n')

        var mostCalories = 0
        var comparisonCalories = 0
        elfCalories.forEach { cal :String ->

            if (cal.equals('\n') || cal == "") {
                if (comparisonCalories > mostCalories) {
                    mostCalories = comparisonCalories
                }
                comparisonCalories = 0
            } else {
                comparisonCalories += cal.toInt()
            }
        }

        val dayOneFirstAnswer: TextView = findViewById(R.id.day_one_first_answer)
        dayOneFirstAnswer.text = mostCalories.toString()
    }
}