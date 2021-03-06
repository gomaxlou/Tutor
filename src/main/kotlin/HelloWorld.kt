import kotlin.math.pow

fun main() {
    println("Hello Kotlin")
    println(2f.pow(5))

    println(greeting("Gx") {
        "Hi ${it.toUpperCase()}"
    })
    println(greeting("Gx") {
        "Hello ${it.toLowerCase()}"
    })
}

fun b(param: Int): String {
    return param.toString()
}

// ::b -> function reference, 創建一個 b 函數物件
val d = ::b
val e = d

val f = { i: Int -> i.toString() }

//function reference
val g = Int::toString


fun greeting(name: String, say: (String) -> String) = say(name)