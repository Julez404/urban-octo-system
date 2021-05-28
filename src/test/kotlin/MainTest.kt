import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import kotlin.IllegalArgumentException

class MainTest {
    @Test
    fun MainLoopThrowsIllegalArgumentException()  {
        assertThrows<IllegalArgumentException>{
            val strings = arrayOf("January", "February", "March")
            main(strings)
        }
    }

    @Test
    fun MainLoopDoesNotThrowsIllegalArgumentException()  {
        assertDoesNotThrow{
            val strings = emptyArray<String>()
            main(strings)
        }
    }
}