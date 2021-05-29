import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class TestMain {
    @Test
    fun mainLoopThrowsIllegalArgumentException() {
        assertThrows<IllegalArgumentException> {
            val strings = arrayOf("January", "February", "March")
            main(strings)
        }
    }

    @Test
    fun mainLoopDoesNotThrowsIllegalArgumentException() {
        assertDoesNotThrow {
            val strings = emptyArray<String>()
            main(strings)
        }
    }
}