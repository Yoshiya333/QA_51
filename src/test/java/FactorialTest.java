import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactorialTest {

    Factorial factorial = new Factorial();

    @Test
    void factorial5Test(){

        assertEquals(120, factorial.calculate(5));
    }

    @Test
    void factorialZeroTest(){

        assertEquals(1, factorial.calculate(0));
    }

}
