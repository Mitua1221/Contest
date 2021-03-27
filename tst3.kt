package aaa

fun main() {

    val string = readLine()!!

    var char: MutableList<Char> = mutableListOf()

    for (i in string.indices) {
        char.add(string[i])
    }

    char.removeAll(listOf(' '))

    var maxValue: Int = 0
    var maxOneIndex: Int = 0
    var maxTwoIndex: Int = 0

    for (i in 0 until char.size) {

        if (char[i].toString().toInt() > 5) {
            char[i] = '5'
        }

        if (char[i].toInt() > maxValue) {
            maxValue = char[i].toInt()
            maxOneIndex = i
        } else {
            if (char[i].toInt() == maxValue ) {
                maxTwoIndex = i
            }
        }
    }

    //х3

    if (maxTwoIndex == 0) {
        maxTwoIndex = maxOneIndex
    }

    for (i in maxOneIndex .. maxTwoIndex) {
        char[i] = maxValue.toChar()
    }

    var maxLeft: Char = '0'
    var maxLeftInt: Int = 0
    var maxLeftIndex: Int = 0


    for (i in 0 .. 5){
        for (j in 0 until maxOneIndex) {
            if (char[j].toString().toInt() > maxLeftInt) {
                maxLeft = char[j]
                maxLeftInt = char[j].toString().toInt()
                maxLeftIndex = j
            }
        }
        for (j in maxLeftIndex until maxOneIndex) {
            char[j] = maxLeft
        }
        maxOneIndex = maxLeftIndex
        maxLeft = '0'
        maxLeftInt = 0
        maxLeftIndex = 0
    }

    char.reverse()

    maxLeft = '0'
    maxLeftInt = 0
    maxLeftIndex = 0

    maxOneIndex = char.size - 1 - maxTwoIndex

    for (i in 0 .. 5){
        for (j in 0 until maxOneIndex) {
            if (char[j].toString().toInt() > maxLeftInt) {
                maxLeft = char[j]
                maxLeftInt = char[j].toString().toInt()
                maxLeftIndex = j
            }
        }
        for (j in maxLeftIndex until maxOneIndex) {
            char[j] = maxLeft
        }
        maxOneIndex = maxLeftIndex
        maxLeft = '0'
        maxLeftInt = 0
        maxLeftIndex = 0
    }

    char.reverse()

    for (i in 0 until char.size) {
        print("${char[i]} ")
    }

}

//0 1 2 3 4 5 4 3 2 2 1 0
//0 00 110011 01  22 111 22 3123 4 1  22  3 44  5 1 2 3 4 5 1 2 3 4 5 1 2 3 4 5  13 0000 132 13123 004 1231210
