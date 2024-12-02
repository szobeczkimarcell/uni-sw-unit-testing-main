package uni.sw.unit.testing;

public class Fibonacci {
    // Not implemented method
    public int getFibonacciNI(int n)
    {
        return 0;
    }
    
    // Implemented method
    public int getFibonacciNumber(int n)
    {
        int a = 0;
        int b = 1;
        for(int i = 1; i<n; i++)
        {
            int temp = a;
            a = b;
            b += temp;
        }
        return a;
    }
}