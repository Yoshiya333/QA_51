import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    Calculator calculator = new Calculator();


    @Test
    void sumTest() {
        assertEquals(5, calculator.sum(2, 3));
    }


    @Test
    void subtractionTest() {
        assertEquals(2, calculator.subtract(5, 3));
    }


    @Test
    void multiplicationTest() {
        assertEquals(15, calculator.multiply(5, 3));
    }


    @Test
    void divisionTest() {
        assertEquals(2, calculator.divide(6, 3));
    }
}