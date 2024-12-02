package uni.sw.unit.testing;

import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;    

@Disabled
@DisplayName("Parameterized Tests")
public class TriangleParameterizedTest {

    private static Stream<Arguments> testData() {

        return Stream.of(
          Arguments.of("generic", 3,4,6, false, false, false),
          Arguments.of("isosceles", 3,6,6, true, false, false),
          Arguments.of("equilateral", 10,8,8, true, false, false)
          );
    }

    
    @ParameterizedTest(name="Test {0} triangle with the side lengths of {1}, {2}, {3}")
    @MethodSource("testData")
    void testTriangle(String name, int a, int b, int c, boolean expectedIsosceles, boolean expectedEquilateral, boolean expectedRightAngeled){
        Triangle triangle = new Triangle(a, b, c);
        
        assertEquals(triangle.isIsosceles(), expectedIsosceles);
        assertTrue(triangle.isEquilateral() == expectedEquilateral);
        assertTrue(triangle.isRightAngeled() == expectedRightAngeled);
    }   
}


