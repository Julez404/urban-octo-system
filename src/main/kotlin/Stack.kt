import java.nio.BufferUnderflowException

class Stack {
    private val elements: MutableList<Int> = mutableListOf()

    @Throws(BufferUnderflowException::class)
    fun pop(): Int{
        if(elements.isEmpty())
            throw BufferUnderflowException()
        var retVal = elements.last()
        var delete = elements.last()
        elements.remove(delete)
        return retVal
    }

    fun push(element: Int){
        elements.add (element)
    }

    fun isEmpty(): Boolean {
        return elements.isEmpty();
    }
}