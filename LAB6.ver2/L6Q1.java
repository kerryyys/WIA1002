package queue;

import java.util.*;

public class L6Q1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter transactions: ");
        String input = sc.nextLine();
        String[] input2 = input.split(" \\| ");

        System.out.println("Input Transactions:");
        for (int i = 0; i < input2.length; i++) {
            System.out.print(input2[i] + " --> ");
        }

        int initial = 500;
        Queue<String> trans = new LinkedList<>();

        for (int i = 0; i < input2.length; i++) {
            trans.offer(input2[i].split(" ")[0]);
            trans.offer(input2[i].split(" ")[1]);
        }

        System.out.println("\nInitial Balance: " + initial);

        while (!trans.isEmpty()) {
            String transaction = trans.poll();
            String amount = trans.poll();

            if (transaction.equals("D")) {
                initial += Integer.parseInt(amount);
                System.out.println("Deposit " + amount + "\t\tNew Balance: " + initial);
            } else if (transaction.equals("W")) {
                if (Integer.parseInt(amount) <= initial) {
                    initial -= Integer.parseInt(amount);
                    System.out.println("Withdraw " + amount + "\t\tNew Balance: " + initial);
                } else {
                    System.out.println("Withdraw " + amount + " Rejected" + "\tNew Balance: " + initial);
                }
            }
        }
    }
}
