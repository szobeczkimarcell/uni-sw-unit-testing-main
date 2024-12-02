package uni.sw.unit.testing.mocking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import uni.sw.unit.testing.Triangle;

public class TriangleMockTest {

    @Test
    @ExtendWith(MockitoExtension.class)
    public void mockTest() {
        Triangle mockTriangle = Mockito.mock(Triangle.class);
        
        // Mock the behavior of isIsosceles method
        when(mockTriangle.isIsosceles()).thenReturn(false);
        assertEquals(false, mockTriangle.isIsosceles(), "Triangle should not be isosceles");

        // Mock the behavior of isEquilateral method
        when(mockTriangle.isEquilateral()).thenReturn(false);
        assertEquals(false, mockTriangle.isEquilateral(), "Triangle should not be equilateral");

        // Mock the behavior of isRightAngeled method
        when(mockTriangle.isRightAngeled()).thenReturn(true);
        assertEquals(true, mockTriangle.isRightAngeled(), "Triangle should be right angled");

        // Mock the behavior of getPerimeter method
        when(mockTriangle.getPerimeter()).thenReturn(12);
        assertEquals(12, mockTriangle.getPerimeter(), "Triangle perimeter should be 12");

        // Mock the behavior of getArea method
        when(mockTriangle.getArea()).thenReturn(6.0);
        assertEquals(6.0, mockTriangle.getArea(), "Triangle area should be 6");

        // Verify the methods were called
        verify(mockTriangle).isIsosceles();
        verify(mockTriangle).isEquilateral();
        verify(mockTriangle).isRightAngeled();
        verify(mockTriangle).getPerimeter();
        verify(mockTriangle).getArea();
    }
}
