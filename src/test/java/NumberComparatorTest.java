import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberComparatorTest {

    NumberComparator comparator = new NumberComparator();

    @Test
    void firstNumberIsBigger(){

        assertEquals(
                "Первое число больше",
                comparator.compare(10,5)
        );
    }

    @Test
    void SecondNumberIsBigger(){

        assertEquals(
                "Второе число больше",
                comparator.compare(4,15)
        );
    }

    @Test
    void NumbersAreEqual(){

        assertEquals(
                "Числа равны",
                comparator.compare(200,200)
        );
    }
}
