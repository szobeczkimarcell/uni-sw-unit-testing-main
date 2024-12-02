package uni.sw.unit.testing.mocking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import uni.sw.unit.testing.Fibonacci;

public class FibonacciMockTest {
    
    @Test
    @ExtendWith(MockitoExtension.class)
    public void mockTest() {
        Fibonacci mock = Mockito.mock(Fibonacci.class);

        //15. Fibonacci number (377)
        when(mock.getFibonacciNI(15)).thenReturn(377);
        assertEquals(377, mock.getFibonacciNI(15), "15. number should be 377");

        // 20. Fibonacci number (4181)
        when(mock.getFibonacciNI(20)).thenReturn(4181);
        assertEquals(4181, mock.getFibonacciNI(20), "20. number should be 4181");

        // Verify the methods were called
        verify(mock).getFibonacciNI(15);
        verify(mock).getFibonacciNI(20);
    }
}
