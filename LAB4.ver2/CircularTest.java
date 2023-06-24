package LinkedList;

import java.util.Scanner;

public class CircularTest {
    public static void main(String[] args) {
        System.out.println("Enter a sentence");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] a = input.split(" ");
        CircularLinkedList<String> circular = new CircularLinkedList<>();
        System.out.println("The word in the circular linked list");
        for (int i = 0; i < a.length; i++) {
            circular.addCircularNode(a[i]);
        }
        circular.showCircularList();

        System.out.println("\nAfter delete a word");
        circular.deleteCircularNode();
        circular.showCircularList();
    }
}
