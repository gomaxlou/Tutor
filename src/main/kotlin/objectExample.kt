fun main() {
    Hsinchu0.printSite() // singleton
    Hsinchu1.Direct.printSite() // 靜態使用
    Hsinchu2.printSite() // 省略 object name
}


// singleton 用法
object Hsinchu0 {
    var name = ""
    val site = "hsinchu.io"
    fun printSite() = println(site)
}

// 非單例並且需要static 變數及方法
class Hsinchu1 {
    var name: String = ""

    object Direct {
        val site = "hsinchu.io"
        fun printSite() = println(site)
    }
}

// 加了companion 就可以省略 object name, 使用時就更省事
// 等同於Java的靜變方法及變數
class Hsinchu2 {
    var name: String = ""

    companion object {
        val site = "hsinchu.io"
        fun printSite() = println(site)
    }
}