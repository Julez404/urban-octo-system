import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.nio.BufferUnderflowException

class TestStack {
    var stack = Stack()

    @BeforeEach
    fun createStackObj() {
        stack = Stack()
    }

    @Test
    fun popReturnsPushedValue() {
        var pushElement = 12
        stack.push(pushElement)
        Assertions.assertEquals(pushElement, stack.pop())
    }

    @Test
    fun pushMultipleElementsAndPopAfterward() {
        stack.push(5)
        stack.push(10)
        stack.push(-90)
        Assertions.assertEquals(-90, stack.pop())
        Assertions.assertEquals(10, stack.pop())
        Assertions.assertEquals(5, stack.pop())
    }

    @Test
    fun push3pop4throwsUnderflowException() {
        stack.push(5)
        stack.push(10)
        stack.push(-90)
        Assertions.assertEquals(-90, stack.pop())
        Assertions.assertEquals(10, stack.pop())
        Assertions.assertEquals(5, stack.pop())
        assertThrows<BufferUnderflowException> {
            stack.pop()
        }
    }

    @Test
    fun popOnEmptyStackThrowsException() {
        assertThrows<BufferUnderflowException> {
            stack.pop()
        }
    }

    @Test
    fun isEmptyReturnsTrueWhenEmpty() {
        Assertions.assertTrue(stack.isEmpty())
        stack.push(90)
        stack.pop()
        Assertions.assertTrue(stack.isEmpty())
    }

    @Test
    fun isEmptyReturnsFalseWhenNotEmpty() {
        stack.push(90)
        Assertions.assertFalse(stack.isEmpty())
        stack.pop()
        stack.push(90)
        stack.push(90)
        Assertions.assertFalse(stack.isEmpty())
    }
}