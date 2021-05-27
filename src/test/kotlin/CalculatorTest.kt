import org.junit.Test
import kotlin.test.assertEquals

public class CalculatorTest {
    @org.junit.Test
    fun SumOfPositiveNumbers() {
        val calculator = Calculator()

        assertEquals(4, calculator.Add(2,2))
        assertEquals(266, calculator.Add(10,256))
        assertEquals(9000, calculator.Add(0,9000))
        assertEquals(180000, calculator.Add(90000,90000))
    }

    @org.junit.Test
    fun SumOfNegativeNumbers() {
        val calculator = Calculator()

        assertEquals(-4, calculator.Add(-2,-2))
        assertEquals(-266, calculator.Add(-10,-256))
        assertEquals(-9000, calculator.Add(-0,-9000))
        assertEquals(-180000, calculator.Add(-90000,-90000))
    }

    @org.junit.Test
    fun SumOfPositiveAndNegativeNumbers() {
        val calculator = Calculator()

        assertEquals(0, calculator.Add(-2,2))
        assertEquals(-246, calculator.Add(10,-256))
        assertEquals(-9000, calculator.Add(0,-9000))
        assertEquals(0, calculator.Add(-90000,90000))
    }
}
