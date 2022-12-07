package com.example.adventofcode2022

class Day1CalorieCounting(private var input: String): Day() {
    var calorieTotalsByElf = getData()

    override fun firstPuzzle(): String {
        return calorieTotalsByElf.maxOrNull().toString()
    }

    override fun secondPuzzle(): String {
        return calorieTotalsByElf.sortedDescending().subList(0,3).sum().toString()
    }

    override fun getData(): List<Int> {
        val allElfCalories = input
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
}