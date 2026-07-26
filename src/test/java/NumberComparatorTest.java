import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class NumberComparatorTest {

    NumberComparator comparator = new NumberComparator();

    @Test
    public void firstNumberIsBigger(){

        assertEquals(
                "Первое число больше",
                comparator.compare(10,5)
        );
    }

    @Test
    public void SecondNumberIsBigger(){

        assertEquals(
                "Второе число больше",
                comparator.compare(4,15)
        );
    }

    @Test
    public void NumbersAreEqual(){

        assertEquals(
                "Числа равны",
                comparator.compare(200,200)
        );
    }
}
