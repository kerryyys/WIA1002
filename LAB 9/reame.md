# Recursive <br>

Here are the key aspects and steps involved in creating a recursive method:<br>

Base Case: A recursive method must have one or more base cases, which are the simplest cases that can be solved directly without further recursion. These base cases are essential to prevent infinite recursion and provide termination conditions for the method.<br>

Recursive Step: In addition to the base case(s), a recursive method includes a recursive step. This step breaks down the original problem into smaller, similar subproblems and calls the same method to solve them. The recursive step should be designed in a way that each recursive call brings the problem closer to the base case(s).<br>

Parameters and Return Value: Recursive methods typically take one or more parameters representing the problem or subproblem. They may also return a value that represents the result of solving the problem.<br>

Flow of Execution: When a recursive method is called, it executes the base case(s) if the termination condition is met. Otherwise, it executes the recursive step, making one or more recursive calls to itself with modified parameters. The method continues to call itself until the base case(s) are reached, and then it starts returning the results back to the initial call.<br>
{
public class FactorialCalculator {
    public static int factorial(int n) {
        // Base case: factorial of 0 or 1 is 1
        if (n == 0 || n == 1) {
            return 1;
        }
        // Recursive step: n! = n * (n-1)!
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        int number = 5;
        int result = factorial(number);
        System.out.println("Factorial of " + number + " is " + result);
    }
}
}
