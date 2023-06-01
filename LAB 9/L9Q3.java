/*Write a recursive method called exponent(x,y) to perform exponentiation return xy, assuming
y >= 0. Example:
exponent(10,3) → will produce an output of 1000
Method signature as follows:
public static long exponent(int x, int m) {
} */
package LAB9;

public class L9Q3 {
    public static void main(String[] args) {
        
        System.out.println(exponent(10, 3));
    }

    public static long exponent(int x, int m) {

        // Base Case
        if (m == 0) return 1;

        // Recursion
        return x * exponent(x, m - 1);
    }
}
