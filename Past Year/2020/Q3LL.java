package py2020;

import java.util.*;

public class Q3LL {

    private int size;
    private Node<String> head;

    public Q3LL() {
        head = new Node<>();
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void createNode(String e, int sale) {
        Node<String> newNode = new Node<>();
        newNode.element = e;
        newNode.next = null;
        newNode.prev = null;
        newNode.sales = sale;
        if (isEmpty()) {
            head = newNode;
        } else {
            Node<String> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
        size++;
    }

    public void addAfter(String e, String nextE, int sale) {
        Node<String> current = head;
        int position = 0;
        while (!current.element.equals(e) && current != null) {
            current = current.next;
            position++;
        }
        if (current != null) {
            Node<String> newNode = new Node<>();
            newNode.element = nextE;
            newNode.sales = sale;
            newNode.prev = current;
            newNode.next = current.next;
            if (current.next != null) {
                current.next.prev = newNode;
            }
            current.next = newNode;
            size++;
            System.out.println("Adding " + nextE + " after " + e);
            System.out.println("Found " + e + "which is book number " + position + " in the linked list");
            display();
        } else {
            System.out.println("Could not find the book name\n");
        }
    }

    public void removeNode(String e) {
    Node<String> current = head;
    System.out.println("Removing " + e);
    int position = 0;

    while (current != null && !current.element.equals(e)) {
        current = current.next;
        position++;
    }

    if (current != null && current.element.equals(e)) {
        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            head = current.next; // If node to be removed is head, update head;
        }

        if (current.next != null) {
            current.next.prev = current.prev;
        }

        size--;
        System.out.println(e + " is book number " + position + ". Removing " + e + " from the linked list.");
    } else {
        System.out.println("Could not find bookname");
    }
}

    public void display() {
        Node<String> current = head;
        System.out.println("\nDisplaying the Linked List-------------------------------");
        while (current != null) {
            System.out.println(current.element + " : " + current.sales * 1000000 + " Sold");
            current = current.next;
        }
        System.out.println("");
    }
}

class Node<E> {

    public Node<E> next;
    public Node<E> prev;
    public int sales;
    public E element;

    public Node() {
    }

}
