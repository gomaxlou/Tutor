import java.util.stream.Collectors.groupingBy

fun main() {

//    exArray()
//    exList()
//    exSet()
//    exMap()
    misc()
}

fun exArray() {

    // 宣告
    val myArray = arrayOf(1, 2, 3, 4, 5)
    val emptyArray = arrayOf<Int>()
    val emptyArray2 = emptyArray
    val emptyArray3 = arrayOfNulls<Int?>(0)

    // for Java Primitive Type
    val intArray = intArrayOf(1, 2, 3, 4, 5)
    val booleanArray = booleanArrayOf(true, false)
    val floatArray = floatArrayOf(1.0f, 2.0f, 3.0f)
    val doubleArray = doubleArrayOf(1.0, 2.0)

    // 操作
    println(myArray[0]) // 索引取值
    for (item in myArray) { // 迴圈取值
        println(item)
    }
    myArray.forEach { println(it) } // 另一種迴圈取值

    myArray.forEach(::println) // 迴圈 + lambda

    println("${myArray.size}, ${myArray.sum()}, ${myArray.average()} ${myArray.maxOrNull()}") // array的屬性及方法
    println(myArray.plus(6).last())
}

fun exList() {

    // 宣告
    val myList = mutableListOf(1, 2, 3, 4, 5)
    val emptyList = listOf<Int>()
    val mutableListOf = mutableListOf("A", "B", "C")

    // 讀取
    println(myList[0])
    println(myList.get(0))
    myList.forEach { println(it) }
    println("${myList.size}, ${myList.sum()}, ${myList.maxOrNull()}")

    // 新增
    myList.add(6) // [1, 2, 3, 4, 5, 6]
    myList.add(0, -1) // [-1, 1, 2, 3, 4, 5, 6]
    myList.addAll(listOf(9, 10))// [-1, 1, 2, 3, 4, 5, 6, 9, 10]
    myList += 11 // [-1, 1, 2, 3, 4, 5, 6, 9, 10, 11]
    myList += listOf(12, 13) // [-1, 1, 2, 3, 4, 5, 6, 9, 10, 11, 12, 13]
    println(myList)

    // 更新
    myList[0] = 0 // [0, 1, 2, 3, 4, 5, 6, 9, 10, 11, 12, 13]
    myList.set(1, 2) // [0, 2, 2, 3, 4, 5, 6, 9, 10, 11, 12, 13]
    myList.replaceAll { it + 1 } // [1, 3, 3, 4, 5, 6, 7, 10, 11, 12, 13, 14]
    println(myList)

    // 刪除
    myList.remove(1) // [3, 3, 4, 5, 6, 7, 10, 11, 12, 13, 14]
    myList.removeAt(2) // [3, 3, 5, 6, 7, 10, 11, 12, 13, 14]
    myList.removeFirstOrNull() // [3, 5, 6, 7, 10, 11, 12, 13, 14]
    myList.removeLastOrNull() //  [3, 5, 6, 7, 10, 11, 12, 13]
    myList.removeAll { it > 11 } // [3, 5, 6, 7, 10, 11]
    myList -= 3 // [5, 6, 7, 10, 11]
    myList -= listOf(7, 10) // [5, 6, 11]
    myList.removeIf { it == 11 } // [5, 6]
    println(myList)

    // 保留(反向刪除)
    myList.retainAll { it > 5 } // [6]
    println(myList)
}

fun exSet() {

    //宣告
    val mySet = setOf(1, 1, 2, 3, 4, 5)
    val emptySet = setOf<Int>()
    val mutableSet = mutableListOf<String>()

    // 操作
    println(mySet.elementAt(0))
    println(mySet.elementAtOrElse(0) { "99" })
    println(mySet.elementAtOrNull(0))
    println(mySet.randomOrNull())
    mySet.forEach { println(it) }
    println("${mySet.size}, ${mySet.sum()}, ${mySet.maxOrNull()}")
}

fun exMap() {
    // 宣告
    val myMap = mapOf("A" to 1, "B" to 2)
    val emptyMap = mapOf<String, Int>()
    val mutableMapOf = mutableMapOf<String, Int>()

    // 操作
    println(" ${myMap["A"]}")
    myMap.forEach { k, v ->
        println("$k : $v")
    }

    println("${myMap.size}, ${myMap.count()}, ${myMap.keys}, ${myMap.values}")
}

fun misc() {

    // 取值例外
    val listOfNames = mutableListOf("Tom", "John", "Allen", "Sean", "Jacky", "Alice", "Wendy", "Jane")

    listOfNames.run {
        // getOrNull + Elvis(?:)
        println(getOrNull(4) ?: "unKnown person")

        // getOrElse + lambda({})
        println(getOrElse(4) { "unKnown person" })

        println(elementAtOrElse(4) { "unknown person" })

        // 回傳第一個滿足條件的值，否則拋出NoSuchElementException, 若沒有給條件就回值第一個值
        println(firstOrNull())  // 未提供取值條件
        // 提供取值條件
        println(first { it.length > 3 }) // 回傳第一個滿足條件的值
        println(last { it.length > 3 })  // 回傳最後一個滿足條件的值

        // take / drop
        println(take(2))
        println(takeLast(2))
        println(takeIf {
            it.size >= 3
        })
        println(takeWhile {
            it.length == 3
        })

        println("Slice, Chunked, windowed, zipwithnext ".plus(".".repeat(20)))
        // 截取一段範圍
        println(slice(2..5))
        println(slice(0..4 step 2))
        // 給指定的 index，依照該 index Collection 回傳元素
        println(slice(setOf(0, 3, 5)))

        // 切成小塊
        println(chunked(3))
        println(chunked(3) { it.take(2) })

        // 設定一段範圍，然後以這個範圍逐步移動來取出元素
        println(windowed(3))
        println(windowed(3, 2))
        println(windowed(3, 2, true))
        // 將前後相鄰的兩個元素切成一個個 Pair
        println(zipWithNext())
        println(zipWithNext() { s1, s2 ->
            if (s1.length > s2.length) {
                s1 to s2
            } else {
                s2 to s1
            }
        })

        // 兩兩一組，留下前面名子長度大於後者
        println(zipWithNext().filter {
            it.first.length > it.second.length
        })

        // 過濾
        println("filter, partition".plus(".".repeat(30)))
        println(filterIndexed { index, s ->
            index > 2 && s.length > 4
        })

        // 切割
        println(partition {
            it.length > 4
        })

        // 排序
        println("排序".plus(".".repeat(50)))
        println(sorted())
        println(sortedDescending())
        println(sortedBy { it.length })
        println(sortedByDescending { it.last() })// sort by 最後一個字元

        // 反轉
        println("反轉".plus(".".repeat(50)))
        println(reversed())
        val asReversedList = asReversed() // as view
        add("Gx") // listOfNames 新增一個值, asReversedList同步更新
        println(asReversedList)

        // 隨機排序
        println(shuffled())

        // 檢查？
        println("檢查包含".plus(".".repeat(50)))
        println(contains("Gx"))
        println("Gx" in this)
        println(containsAll(listOf("Wendy", "Alice", "Michi")))
        println(isEmpty())
        println(isNotEmpty())
        println(any())
        println(none())
        println(all { it.length > 3 })

        // 搜尋
        println("搜尋 find".plus(".".repeat(50)))
        println(find { it.startsWith("A") })
        println(findLast { it.startsWith("A") })
        println(indexOf("Alice"))
        println(indexOfFirst { it.contains("J") })

        // 群組
        println("群組 group".plus(".".repeat(50))) // 用 Lambda 分組
        println(groupBy { it.first() }) // 用 Lambda 分組後再操作

        // 分組後再做轉型
        // keySelector，意思就是用什麼當做 key 的分組條件
        // valueTransform，意思就是要在 value 執行什麼轉換
        println(groupBy(
            keySelector = { it.first() },
            valueTransform = { it.toUpperCase().repeat(2) }
        ))

        // 分組後再做操作
        println(groupingBy {
            it.first()
        }.eachCount())

        // 操作轉換
        println(map { it.toUpperCase() })
        println(mapNotNull { it.toUpperCase() })


    }

    // 過濾Type, null, 重複
    println("filter type, null, duplicated".plus(".".repeat(30)))
    val mixList = listOf("ABC", 1, 2.0, true, null, 1, true)
    mixList.run {
        println(filterIsInstance<Int>())
        println(filterIsInstance<String>())
        println(filterNotNull())
        println(distinct())

    }

    val animals = listOf("lion", "dog", "cat", "rabbit", "wolf", "bear")
    val fruits = listOf("banana", "apple", "orange", "watermelon")
    println(animals.zip(fruits))
    println(animals zip fruits) // support infix

    // zip + lambda (傳入lambda 做第二個參數，取得pair裡的animal, fruit)
    println(animals.zip(fruits) { animal, fruit ->
        "The $animal love $fruit"
    })
    // zip + map (同上面的結果)
    println(animals.zip(fruits).map {
        "The ${it.first} love ${it.second}"
    })

    // 將處理過的結果做關聯
    // key: elements, value: lambda, return map
    println(animals.associateWith { it.length }) // {lion=4, dog=3, cat=3, rabbit=6, wolf=4, bear=4}

    // 將結果儲存至destMap, 但其實associateWithTo 也有回傳結果
    val destMap = mutableMapOf<String, Int>()
    val associateWithTo = animals.associateWithTo(destMap) { it.length }
    println("destMap: $destMap") // destMap: {lion=4, dog=3, cat=3, rabbit=6, wolf=4, bear=4}
    println(associateWithTo)

    // 把原本 Collection 裡的elements當成 value
    // key: lambda, value: elements
    println(animals.associateBy { it.first().toUpperCase() }) // {L=lion, D=dog, C=cat, R=rabbit, W=wolf, B=bear}
    println(animals.associateBy(
        keySelector = { it.first() }, // key : 元素的第一個字母
        valueTransform = { it.length }, // value : 元素的長度
    )) // {l=4, d=3, c=3, r=6, w=4, b=4}

    // associate() 的作法則是將 Collection 的元素傳給 Lambda，
    // Lambda 則要回傳一個 Pair，最後會將這成群的 Pair 轉成 Map 回傳
    println(animals.associate {
        it.first() to it.length
    })

    animals.associateTo(destMap) { it to it.length + 1 }
    animals.associateByTo(
        destMap,
        keySelector = { it.toUpperCase() },
        valueTransform = String::length,
    )

    // 集合平面化 flatten, flatMap

    // output
    println(animals.joinToString(separator = " |", prefix = "start:", postfix = " : end"))
    println(animals.joinToString(limit = 2, truncated = "...")) // lion, dog, ...
    println(animals.joinToString {
        it.toUpperCase()
    })

    // 聚合(Aggregation): 將 Collection 內所有元素做運算，最後回傳「一個值」
    val numbers = listOf(6, 42, 10, 4, 5)
    numbers.run {
        println(sumBy { it * 2 })
        println(sumByDouble { it.toDouble() * 2 })
        println(maxOrNull())
        println(maxByOrNull { it % 3 })
    }

    println(animals.maxWithOrNull(compareBy { it.length }))

    numbers.run {
        // 從左向右計算, 從向至左使用 reduceRight, foldRight, 需要索引值 reduceIndex, foldIndex
        println(reduce { sum, element ->
            sum + element
        }) // 67
        // fold 可設初始值
        println(fold(1) { sum, element ->
            sum + element
        }) // 68

        // 空值處理 所有method 以 orNull 結尾
        println(reduceRightOrNull { sum, element ->
            sum + element
        })

    }

    // Iterable vs Sequence
    val words = "The quick brown fox jumps over the lazy dog".split(" ")
    val lengthsList =
        words
            .filter {
                println("filter $it")
                it.length > 3
            }
            .map {
                println("length: ${it.length}")
                it.length
            }
            .take(4)
    println(lengthsList)

    val wordsSequence = words.asSequence()
    val lengthsSequence =
        wordsSequence
            .filter {
                println("filter $it")
                it.length > 3
            }
            .map {
                println("length: ${it.length}")
                it.length
            }
            .take(4)
    println(lengthsSequence.toList())
}