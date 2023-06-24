package LinkedList;

import java.util.Scanner;

public class L4Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a word: ");
        String word = sc.nextLine();
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < word.length(); i++) {
            char a = word.charAt(i);
            list.addLast(a);
        }

        System.out.println("Split the list into two");
        list.splitList();

        System.out.println("\nSplit the list by alternating the nodes");
        list.alternateList();

        System.out.println("\nMerge first list and second list by alternating the nodes");
        LinkedList<Character> mergedList = list.mergeList();
        mergedList.displayList("");

        System.out.println("\nReverse the list. Recursive method in the LinkedList");
        list.reverseList();
        list.displayList("");

        System.out.println("\nReverse the list. Recursive method in the tester class");
        LinkedList<Character> reversedList = recursiveReverseList(list);
        reversedList.displayList("");
    }

    public static <E extends Comparable<E>> LinkedList<E> recursiveReverseList(LinkedList<E> list) {
        LinkedList<E> reversedList = new LinkedList<>();
        recursiveReverse(list.getHead(), reversedList);
        return reversedList;
    }

    private static <E extends Comparable<E>> void recursiveReverse(ListNode<E> current, LinkedList<E> reversedList) {
        if (current == null) {
            return;
        }
        recursiveReverse(current.getNext(), reversedList);
        reversedList.addLast(current.getElement());
    }
}
