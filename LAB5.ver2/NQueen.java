package stack;

import java.util.*;

import java.util.*;
public class NQueen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the N");
        int n = sc.nextInt();
        System.out.println("Solving the " + n + " Queen Problem");
        List<List<String>> solutions = solveNQueens(n);
        printSolutions(solutions);
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        solveNQueensUtil(n, 0, new int[n], solutions);
        return solutions;
    }

    private static void solveNQueensUtil(int n, int row, int[] queens, List<List<String>> solutions) {
        if (row == n) {
            solutions.add(generateSolution(queens));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(row, col, queens)) {
                queens[row] = col;
                solveNQueensUtil(n, row + 1, queens, solutions);
            }
        }
    }

    private static boolean isSafe(int row, int col, int[] queens) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col || queens[i] - i == col - row || queens[i] + i == col + row) {
                return false;
            }
        }
        return true;
    }

    private static List<String> generateSolution(int[] queens) {
        List<String> solution = new ArrayList<>();
        int n = queens.length;

        for (int row = 0; row < n; row++) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < n; col++) {
                if (queens[row] == col) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            solution.add(sb.toString());
        }

        return solution;
    }

    private static void printSolutions(List<List<String>> solutions) {
        int count = solutions.size();

        for (List<String> solution : solutions) {
            System.out.println("Solution:");
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
        
        System.out.println("The number of solutions are: " + count);
    }
}