package com.example.adventofcode2022

import java.util.Stack

class Day5SupplyStacks(private var input: String): Day() {
    private val rearrangementProcedure = getData()

    private fun setupStacks(): MutableList<Stack<Char>> {
        val stacks: MutableList<Stack<Char>> = mutableListOf()
        val stack1 = Stack<Char>()
        stack1.addAll(mutableListOf('P', 'F', 'M', 'Q', 'W', 'G', 'R', 'T'))
        val stack2 = Stack<Char>()
        stack2.addAll(mutableListOf('H', 'F', 'R'))
        val stack3 = Stack<Char>()
        stack3.addAll(mutableListOf('P', 'Z', 'R', 'V', 'G', 'H', 'S', 'D'))
        val stack4 = Stack<Char>()
        stack4.addAll(mutableListOf('Q', 'H', 'P', 'B', 'F', 'W', 'G'))
        val stack5 = Stack<Char>()
        stack5.addAll(mutableListOf('P', 'S', 'M', 'J', 'H'))
        val stack6 = Stack<Char>()
        stack6.addAll(mutableListOf('M', 'Z', 'T', 'H', 'S', 'R', 'P', 'L'))
        val stack7 = Stack<Char>()
        stack7.addAll(mutableListOf('P', 'T', 'H', 'N', 'M', 'L'))
        val stack8 = Stack<Char>()
        stack8.addAll(mutableListOf('F', 'D', 'Q', 'R'))
        val stack9 = Stack<Char>()
        stack9.addAll(mutableListOf('D', 'S', 'C', 'N', 'L', 'P', 'H'))

        stacks.addAll(mutableListOf(stack1, stack2, stack3, stack4, stack5, stack6, stack7, stack8, stack9))
        return stacks
    }

    private fun setupMockStacks(): MutableList<Stack<Char>> {
        val stacks: MutableList<Stack<Char>> = mutableListOf()
        val stack1 = Stack<Char>()
        stack1.addAll(mutableListOf('Z', 'N'))
        val stack2 = Stack<Char>()
        stack2.addAll(mutableListOf('M', 'C', 'D'))
        val stack3 = Stack<Char>()
        stack3.addAll(mutableListOf('P'))

        stacks.addAll(mutableListOf(stack1, stack2, stack3))
        return stacks
    }

    override fun getData(): List<List<String>> {
        return input.split('\n', ' ').windowed(6, 6)
    }

    override fun firstPuzzle(): String {
        val stacks: MutableList<Stack<Char>> = setupStacks()
        rearrangementProcedure.forEach { movement ->
            val count = movement[1].toInt()
            val from = stacks[movement[3].toInt()-1]
            val to = stacks[movement[5].toInt()-1]

            repeat(count) {
                to.push(from.pop())
            }
        }
        var topCrates = ""
        stacks.forEach { stack ->
            topCrates += stack.pop()
        }
        System.out.println(topCrates)
        return topCrates
    }

    override fun secondPuzzle(): String {
        val stacks: MutableList<Stack<Char>> = setupStacks()
        rearrangementProcedure.forEach { movement ->
            val count = movement[1].toInt()
            val from = stacks[movement[3].toInt()-1]
            val to = stacks[movement[5].toInt()-1]

            val moved = Stack<Char>()
            repeat(count) {
                moved.push(from.pop())
            }
            repeat(count){
                to.push(moved.pop())
            }
        }
        var topCrates = ""
        stacks.forEach { stack ->
            topCrates += stack.pop()
        }
        System.out.println(topCrates)
        return topCrates
    }
}