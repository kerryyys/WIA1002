//Write a Java program that uses a Queue to determine if the input string is a palindrome or not.
package LAB7;
import java.util.Scanner;

public class L7Q2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = input.nextLine();
        input.close();

        MyQueue<Character> queue = new MyQueue<Character>();
        for (int i = str.length() - 1; i >= 0; i--) {
            queue.enqueue(str.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append(queue.dequeue());
        }

        String reversedStr = sb.toString();
        if (str.equals(reversedStr)) {
            System.out.println(str + " is a palindrome.");
        } else {
            System.out.println(str + " is not a palindrome.");
        }
    }
}