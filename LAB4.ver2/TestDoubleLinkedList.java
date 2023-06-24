package LinkedList;

import java.util.Random;

public class TestDoubleLinkedList {
    public static void main(String[] args) {
        Random rand = new Random();
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        int count = 0;
        while (count <= 10) {
            int input = rand.nextInt(101);
            list.addLast(input);
            count++;
        }

        System.out.print("The random number are: ");
        list.iterateForward();
        System.out.println("Insert the random number into the doubly linked list");
        list.display();

        System.out.println("\nRemove a number from the third position");
        list.remove(2);
        list.display();

        System.out.println("\nReplace the number in seventh position with 999");
        list.remove(6);
        list.add(6, 999);
        list.display();

        System.out.println("Remove all even number from the double linked list");
        for (int i = 10 - 1; i >= 0; i--) { //loop from back, so when remove, size change, wont affect
            if (list.get(i) % 2 == 0) {
                list.remove(i);
            }
        }
        list.display();
    }

}
