import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTest {

    Triangle triangle = new Triangle();

    @Test
    void triangleAreaTest(){

        assertEquals(10, triangle.triangleArea(5,4));
    }

    @Test
    void triangleArea2Test(){

        assertEquals(156, triangle.triangleArea(13,24));
    }
}
