@Throws(IllegalArgumentException::class)
fun main(args: Array<String>) {
    if (args.size != 0) {
        for (str in args)
            println(str)
        throw IllegalArgumentException()
    }
    println("Hello?")

    println("Create a Stack")
    val stack = Stack()
}
