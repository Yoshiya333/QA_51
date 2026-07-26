import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class TriangleTest {

    Triangle triangle = new Triangle();

    @Test
    public void triangleAreaTest(){

        assertEquals(10, triangle.triangleArea(5,4));
    }

    @Test
    public void triangleArea2Test(){

        assertEquals(156, triangle.triangleArea(13,24));
    }
}
