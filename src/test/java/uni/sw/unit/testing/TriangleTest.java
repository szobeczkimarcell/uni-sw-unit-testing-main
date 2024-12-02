package uni.sw.unit.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TriangleTest {

    @BeforeAll
    public static void setup(){
        System.out.println("BeforeAll demo: Setup test execution");
    }

    @AfterAll
    public static void tearDown(){
        System.out.println("AfterAll demo: tear down test execution");
    }

    @BeforeEach
    public void initTest(){
        System.out.println("BeforeEach demo: Init test case");
    }

    @AfterEach
    public void tearDownTest(){
        System.out.println("AfterEach demo: tear down test case");
    }

    @Test
    void testGenericTriangle (){
        System.out.println("Testing generic triagle");
        Triangle triangle = new Triangle(3,4,6);

        assertTrue(triangle instanceof Triangle);
        assertFalse(triangle.isIsosceles());
        assertFalse(triangle.isEquilateral());
        assertFalse(triangle.isRightAngeled());
    }
    
    @Test
    void testIsoscelesTriangle (){
        System.out.println("Testing isosceles triangle");
        Triangle triangle1 = new Triangle(3,3,5);

        assertTrue(triangle1.isIsosceles());
        assertFalse(triangle1.isEquilateral());

        Triangle triangle2 = new Triangle(10,8,8);

        assertTrue(triangle2.isIsosceles());
        assertFalse(triangle2.isEquilateral());


        Triangle triangle3 = new Triangle(7,9,7);

        assertTrue(triangle3.isIsosceles());
        assertFalse(triangle3.isEquilateral());

    }

    @Test
    @DisplayName("Test equilateral triangle")
    void testEquilateral (){
        System.out.println("Testing equilateral triangle");
        Triangle triangle = new Triangle(3,3,3);

        assertTrue(triangle.isIsosceles());
        assertTrue(triangle.isEquilateral());
        assertFalse(triangle.isRightAngeled());
    }

    @Test
    @DisplayName("Test right triangle")
    void testRightTriangle (){
        Triangle triangle1 = new Triangle(3,4,5);
        assertTrue(triangle1.isRightAngeled());

        Triangle triangle2 = new Triangle(5,13,12);
        assertTrue(triangle2.isRightAngeled());

        Triangle triangle3 = new Triangle(17,15,8);
        assertTrue(triangle3.isRightAngeled());
    }

    @Test
    @DisplayName("Test perimeter")
    void testPerimeter (){
        Triangle triangle = new Triangle(100, 251, 178);

        assertEquals(triangle.getPerimeter(), 529);
    }

    @Test
    @DisplayName("Test area")
    void testArea (){
        Triangle triangle = new Triangle(3, 4, 5);

        assertEquals(triangle.getArea(), 6);
    }

    @Test
    void testNotConstructableTriangle(){
        Exception exception1 = assertThrows(ArithmeticException.class, () -> {
            new Triangle(0,0,0);
        });

        assertTrue(exception1.getMessage().contains("The triangle cannot be constructed from the the numbers"));

        Exception exception2 = assertThrows(ArithmeticException.class, () -> {
            new Triangle(5,6,12);
        });

        assertTrue(exception2.getMessage().contains("The triangle cannot be constructed from the the numbers"));

        Exception exception3 = assertThrows(ArithmeticException.class, () -> {
            new Triangle(7,6, -2);
        });

        assertTrue(exception3.getMessage().contains("The triangle cannot be constructed from the the numbers"));

        Exception exception4 = assertThrows(ArithmeticException.class, () -> {
            new Triangle(9,16, 7);
        });

        assertTrue(exception4.getMessage().contains("The triangle cannot be constructed from the the numbers"));
    }
}


