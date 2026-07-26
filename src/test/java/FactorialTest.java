import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class FactorialTest {

    Factorial factorial = new Factorial();

    @Test
    public void factorial5Test(){

        assertEquals(120, factorial.calculate(5));
    }

    @Test
    public void factorialZeroTest(){

        assertEquals(1, factorial.calculate(0));
    }

}
