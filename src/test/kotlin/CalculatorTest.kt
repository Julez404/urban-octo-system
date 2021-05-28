import kotlin.test.assertEquals

public class CalculatorTest {
    @org.junit.Test
    fun sumOfPositiveNumbers() {
        val calculator = Calculator()

        assertEquals(4, calculator.add(2,2))
        assertEquals(266, calculator.add(10,256))
        assertEquals(9000, calculator.add(0,9000))
        assertEquals(180000, calculator.add(90000,90000))
    }

    @org.junit.Test
    fun sumOfNegativeNumbers() {
        val calculator = Calculator()

        assertEquals(-4, calculator.add(-2,-2))
        assertEquals(-266, calculator.add(-10,-256))
        assertEquals(-9000, calculator.add(-0,-9000))
        assertEquals(-180000, calculator.add(-90000,-90000))
    }

    @org.junit.Test
    fun sumOfPositiveAndNegativeNumbers() {
        val calculator = Calculator()

        assertEquals(0, calculator.add(-2,2))
        assertEquals(-246, calculator.add(10,-256))
        assertEquals(-9000, calculator.add(0,-9000))
        assertEquals(0, calculator.add(-90000,90000))
    }
}
