package uni.sw.unit.testing;

public class Triangle {
    private int a, b, c;

    public Triangle (int a, int b, int c){
        if ( ((a + b) > c ) && ((b + c) > a ) && ((a + c) > b ) ){
            this.a = a;
            this.b = b;
            this.c = c;    
        }
        else{
            throw new ArithmeticException(
                String.format("The triangle cannot be constructed from the the numbers %d, %d, %d.", a, b, c));
        }
    }

    public boolean isIsosceles(){
        return ((a == b) || (a == c) || (b == c)) ? true : false;
    }

    public boolean isEquilateral(){
        return ( (a == b) && (a == c) ) ? true : false;
    }

    public boolean isRightAngeled(){
        return  ( ( a*a == b*b + c*c ) || ( b*b == a*a + c*c ) || ( c*c == a*a + b*b) ) ? true : false; 
    }

    public int getPerimeter(){
        return a + b + c;
    }

    public double getArea(){
        double s = (a + b + c) / 2;

        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}
