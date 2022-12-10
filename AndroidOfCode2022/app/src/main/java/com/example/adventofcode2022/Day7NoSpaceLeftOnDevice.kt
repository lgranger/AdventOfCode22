package com.example.adventofcode2022

class Day7NoSpaceLeftOnDevice(val input: String): Day() {
    var sumOfSmallDirectorySizes = 0
    val directorySizes: MutableList<Int> = mutableListOf()
    val root = getData()
    override fun getData(): Node {
        val firstNode = Node("/", null, hashMapOf(), hashMapOf(), 0)
        var currentNode = firstNode
        input.split('\n').forEach { line ->
            if (line[0].isDigit()) {
                val values = line.split(" ")
                currentNode.files[values[1]] = values[0].toInt()
            }
            if (line[0] == 'd') {
                currentNode = updateDirectory(currentNode, line.split(' ')[1])
            }
            if (line[0] == '$') {
                val values = line.split(' ')
                if (values[1] == "cd") {
                    currentNode = moveDirectory(currentNode, values[2])
                }
            }
        }
        while (currentNode.parent != null) {
            currentNode.size = calculateSize(currentNode)
            currentNode = currentNode.parent!!
        }
        firstNode.size = calculateSize(firstNode)
        return firstNode
    }

    private fun moveDirectory(currentNode: Node, command: String): Node {
        var moveToDirectory = currentNode
        if (command == "..") {
            currentNode.size = calculateSize(currentNode)
            moveToDirectory = currentNode.parent ?:
                    throw Exception("unable to cd to $command. not a parent of ${currentNode.name}")
        } else if (command != "/") {
            moveToDirectory = currentNode.directory[command] ?:
                    throw Exception("dir $command not found in ${currentNode.name} Node")
        }
        return moveToDirectory
    }

    private fun calculateSize(currentNode: Node): Int {
        val filesSize: Int = currentNode.files.values.sum()
        val directorySize: Int = currentNode.directory.values.sumOf { it.size }
        val size = filesSize + directorySize
        if (size <= SMALL_DIRECTORY_SIZE_LIMIT) {
            sumOfSmallDirectorySizes += size
        }
        directorySizes.add(size)
        return size
    }

    private fun updateDirectory(currentNode: Node, name: String): Node {
        if (!currentNode.directory.contains(name)) {
            currentNode.directory[name] =
                Node(name,currentNode, hashMapOf(), hashMapOf(), 0)
        }
        return currentNode
    }

    override fun firstPuzzle(): String {
        System.out.println(sumOfSmallDirectorySizes)
        return sumOfSmallDirectorySizes.toString()
    }

    override fun secondPuzzle(): String {
        val neededSpace: Int = UPDATE_SIZE - (TOTAL_DISK_SPACE - root.size)
        val directorySizeToDelete = directorySizes.sorted().first { it >= neededSpace }
        return directorySizeToDelete.toString()
    }

    companion object {
        const val SMALL_DIRECTORY_SIZE_LIMIT = 100000
        const val TOTAL_DISK_SPACE = 70000000
        const val UPDATE_SIZE = 30000000
    }
}

class Node(
    val name: String,
    val parent: Node?,
    val files: HashMap<String, Int>,
    val directory: HashMap<String, Node>,
    var size: Int ){ }