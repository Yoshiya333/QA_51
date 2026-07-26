import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class CalculatorTest {

    Calculator calculator = new Calculator();


    @Test
    public void sumTest() {
        assertEquals(5, calculator.sum(2, 3));
    }


    @Test
    public void subtractionTest() {
        assertEquals(2, calculator.subtract(5, 3));
    }


    @Test
    public void multiplicationTest() {
        assertEquals(15, calculator.multiply(5, 3));
    }


    @Test
    public void divisionTest() {
        assertEquals(2, calculator.divide(6, 3));
    }
}