package aaa

import java.util.regex.Pattern

fun main() {

    val string = readLine()!!

    var char: MutableList<Char> = mutableListOf()

    for (i in string.indices) {
        char.add(string[i])
    }


    if (one(char) && two(char) && three(char) && four(char)) {
        println(output(char))
    } else {
        println("error")
    }

}

fun one(char: MutableList<Char>): Boolean {

    var isCorrect = true
    var counter = 0

    for (i in 0 until char.size) {
        if (char[i].isDigit()) {
            counter += 1
        }
        if (char[i].isDigit() || char[i] == ' ' || char[i] == '-' || char[i] == ')' || char[i] == '(' || char[i] == '+') {
            //ok
        } else {
            isCorrect = false
        }
    }

    if (counter != 11) {
        isCorrect = false
    }

    return isCorrect
}

fun two(char: MutableList<Char>): Boolean {

    var isCorrect = true
    var counter = 0


    var first = true
    var s = 0

    try {

        while (first) {

            if (char[s] == '-' || char[s] == '(' || char[s] == ')' || ( char[s] == '+' &&  char[s+1] != '7' )) {
                isCorrect = false
            }

            if (char[s].isDigit()) {
                first = false
            }

            if (char[s] == '7' && char[s-1] == '+' || char[s] == '8') {

            } else {
                if (char[s] != ' ' && char[s] != '+'){
                    isCorrect = false
                }

            }

            s++
        }

    } catch (t: Throwable) {
        isCorrect = false
    }

    for (i in s until char.size) {
        if (char[i] == '+') {
            isCorrect = false
        }
    }

    return isCorrect
}

fun three(char: MutableList<Char>): Boolean {

    var isCorrect = true
    var counter = 0
    var isExistsLeft = false
    var isExistsRight = false

    for (i in 0 until char.size) {
        if (char[i].isDigit()) {
            counter += 1
        }

        var first = 0

        if (counter == 2) {
            var s = i - 1
            if (char[s].isDigit() == false) {
                while (char[s].isDigit() == false) {
                    if (char[s] == ' ' || char[s] == '(') {
                        if (char[s] == '(') {
                            first += 1
                            isExistsLeft = true
                        }
                        s -= 1
                    } else {
                        isCorrect = false
                        s -= 1
                    }
                }
            }
        }

        if (first > 1) {
            isCorrect = false
        }
        first = 0


        try {
            if (counter == 4) {
                var s = i + 1
                if (char[s].isDigit() == false) {
                    while (char[s].isDigit() == false) {
                        if (char[s] == ' ' || char[s] == ')') {
                            if (char[s] == ')') {
                                first += 1
                                isExistsRight = true
                            }
                            s += 1
                        } else {
                            isCorrect = false
                            s += 1
                        }
                    }
                }
            }
        } catch (t: Throwable) {
            isCorrect = false
        }


        if (first > 1) {
            isCorrect = false
        }

    }

    if (isExistsLeft != isExistsRight) {
        isCorrect = false
    }

    return isCorrect
}

fun four(char: MutableList<Char>): Boolean {

    var isCorrect = true
    var counter = 0

    if (char[0] == '-' || char[char.size - 1] == '-') {
        isCorrect = false
    }

    for (i in 0 until char.size - 1) {

        var s = i + 1
        var isFirst = 0
        var brake = false
        while (char[s].isDigit() == false && !brake) {
            if (char[s] == '-') {
                isFirst++
            }

            if (isFirst > 1) {
                isCorrect = false
            }

            if (s < char.size - 1) {
                s++
            } else {
                brake = true
                if (brake && isFirst > 0) {
                    isCorrect = false
                }
            }
        }
    }

    var first = true
    var s = 0

    try {
        while (first) {
            if (char[s].isDigit()) {
                first = false
            }
            if (char[s] == '-') {
                isCorrect = false
            }
            s++
        }
    } catch (t: Throwable) {
        isCorrect = false
    }


    for (i in 0 until char.size) {
        if (char[i].isDigit()) {
            counter += 1
        }

        try {
            if (counter == 2) {
                var s = i + 1
                if (char[s].isDigit() == false) {
                    while (char[s].isDigit() == false) {
                        if (char[s] == '-') {
                            s += 1
                            isCorrect = false
                        } else {
                            s += 1
                        }
                    }
                }
            }
        } catch (t: Throwable) {
            isCorrect = false
        }

        try {
            if (counter == 3) {
                var s = i + 1
                if (char[s].isDigit() == false) {
                    while (char[s].isDigit() == false) {
                        if (char[s] == '-') {
                            s += 1
                            isCorrect = false
                        } else {
                            s += 1
                        }
                    }
                }
            }
        } catch (t: Throwable) {
            isCorrect = false
        }


        try {
            if (counter == 4) {
                var s = i + 1
                if (char[s].isDigit() == false) {
                    while (char[s].isDigit() == false) {
                        if (char[s] == '-') {
                            s += 1
                            isCorrect = false
                        } else {
                            s += 1
                        }
                    }
                }
            }
        } catch (t: Throwable) {
            isCorrect = false
        }

    }

    return isCorrect
}

fun output(char: MutableList<Char>): String  {

    var string: String = ""
    var charTwo: MutableList<Char> = mutableListOf()

    for (i in 0 until char.size) {
        if (char[i].isDigit() == true) {
            charTwo.add(char[i])
        }
    }

    var charThree: MutableList<Char> = mutableListOf()

    for (i in 0..16) {
        charThree.add(' ')
    }

    charThree[0] = '8'
    charThree[1] = ' '
    charThree[2] = '('
    charThree[3] = charTwo[1]
    charThree[4] = charTwo[2]
    charThree[5] = charTwo[3]
    charThree[6] = ')'
    charThree[7] = ' '
    charThree[8] = charTwo[4]
    charThree[9] = charTwo[5]
    charThree[10] = charTwo[6]
    charThree[11] = '-'
    charThree[12] = charTwo[7]
    charThree[13] = charTwo[8]
    charThree[14] = '-'
    charThree[15] = charTwo[9]
    charThree[16] = charTwo[10]

    for (i in 0..16) {
        string += charThree[i]
    }

    return string
}