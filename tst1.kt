package aaa

data class Stock(val a: Int,
                 val b: Int)

fun main() {

    var ticker = true

    val stringOne = readLine()!!

    val k = (stringOne.split(" ")[0])
    val N = k.toInt()//N
    val P = stringOne.removePrefix(k).drop(1).toInt()//P

    if (N >= 10000 || N < 1) {
        ticker = false
        println("NO")
    } else {
        if (P >= 10000 || P < 0) {
            ticker = false
            println("NO")
        } else {
            if (N - P != 1) {
                ticker = false
                println("NO")
            }
        }
    }

    if (ticker) {
        var list = mutableListOf<Stock>()

        var amax: Int = 0
        var amin: Int = 10000
        var bmax: Int = 0

        for (i in 0 until P) {
            val stringTwo = readLine()!!

            val r = (stringTwo.split(" ")[0])
            val a = r.toInt()//a
            val b = stringTwo.removePrefix(r).drop(1).toInt()//b

            if (a < 0 || a >= N || b < 0 || b >= N) {
                ticker = false
            }

            val stock = Stock(a, b)
            list.add(stock)
            if (a > amax) amax = a
            if (a < amin) amin = a
            if (b > bmax) bmax = b
        }
        var fromLeftToRight = true
        if (amax < bmax) fromLeftToRight = false


        var newList = mutableListOf<Stock>()

        for (i in 0 until list.size) {
            if (fromLeftToRight) {
                newList.add(list.find { it.a == amax } ?: Stock(11111, 0))
                amax = newList[i].b
            } else {
                newList.add(list.find { it.a == amin } ?: Stock(11111, 0))
                amin = newList[i].b
            }
        }

        if (newList.find { it.a == 11111 } == Stock(11111, 0)) {
            ticker = false
        }

        if (ticker) {
            println("YES")
        } else {
            println("NO")
        }
    }
}

