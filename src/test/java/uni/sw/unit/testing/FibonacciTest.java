package uni.sw.unit.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FibonacciTest {
    @Test
    void testFibonacciMethod(){
        System.out.println("Testing Fibonacci method");
        Fibonacci fib = new Fibonacci();

        assertEquals(fib.getFibonacciNumber(8), 13);
        assertEquals(fib.getFibonacciNumber(23), 17711);
    }
}
