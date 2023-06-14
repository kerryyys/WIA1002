package LabTest;

import java.util.*;

public class DArbyStack<DArby> {

    private static class Node<E> {
        E item;
        Node<E> next;

        public Node(E item) {
            this.item = item;
            this.next = null;
        }
    }

    private Node<DArby> head = null;
    private int size = 0;

    public void push(DArby item) {
        Node<DArby> newNode = new Node<>(item);
        if (isEmpty()) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public DArby pop() {
        if (isEmpty()) {
            return null;
        }
        DArby item = head.item;
        head = head.next;
        size--;
        return item;
    }

    public DArby peek() {
        return head == null ? null : head.item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(reverseString(head));
        sb.setLength(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    public String reverseString(Node<DArby> node) {
        if (node == null) {
            return "";
        }
        return reverseString(node.next) + node.item + ",";
    }

    public DArby remove(int k) {
        if (k > size || k <= 0) {
            return null;
        }
        if (k == 1) {
            return pop();
        } else {
            Node<DArby> current = head;
            for (int i = 0; i < k - 2; i++) {
                current = current.next;
            }
            DArby item = current.next.item;
            current.next = current.next.next;
            size--;
            return item;
        }
    }
}
