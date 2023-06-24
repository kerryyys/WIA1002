package LinkedList;

import java.util.NoSuchElementException;

public class DoubleLinkedList<E> {
    private DoubleListNode<E> head;
    private DoubleListNode<E> tail;
    private int size;

    public DoubleLinkedList() {
        size = 0;
        this.head = null;
        this.tail = null;
    }

    public void addLast(E o) {
        DoubleListNode<E> newNode = new DoubleListNode<>(o, null, tail);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void addFirst(E o) {
        DoubleListNode<E> newNode = new DoubleListNode<>(o, head, null);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
        }
        size++;
    }

    public void add(int index, E o) {
        if (index > size || index < 0) {
            throw new NoSuchElementException();
        }
        if (index == 0) {
            addFirst(o);
        }
        if (index == size) {
            addLast(o);
        }
        DoubleListNode<E> AfterNewNode = head;
        for (int i = 0; i < index; i++) {
            AfterNewNode = AfterNewNode.next;
        }
        DoubleListNode<E> newNode = new DoubleListNode<>(o, AfterNewNode, AfterNewNode.prev);
        AfterNewNode.prev.next = newNode;
        AfterNewNode.prev = newNode;
        size++;
    }

    public void iterateForward() {

        DoubleListNode<E> newNode = head;
        while (newNode != null) {
            System.out.print(newNode.element + " ");
            newNode = newNode.next;
        }
        System.out.println();
    }

    public void iterateBackward() {

        DoubleListNode<E> newNode = tail;
        while (newNode != null) {
            System.out.print(newNode.element + " ");
            newNode = newNode.prev;
        }
        System.out.println();
    }

    public E removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        DoubleListNode<E> newNode = head;
        head = head.next;
        head.prev = null;
        size--;
        return newNode.element;

    }

    public E removeLast() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        DoubleListNode<E> newNode = tail;
        tail = tail.prev;
        tail.next = null;
        size--;
        return newNode.element;
    }

    public E remove(int index) {
        if (index >= size || index < 0) {
            throw new NoSuchElementException();
        }
        if (index == 0) {
            return removeFirst();
        }
        if (index == size - 1) {
            return removeLast();
        }

        DoubleListNode<E> deleteNode = head;
        for (int i = 0; i < index; i++) {
            deleteNode = deleteNode.next;
        }

        deleteNode.prev.next = deleteNode.next;
        deleteNode.next.prev = deleteNode.prev;
        deleteNode.prev = null;
        deleteNode.next = null;
        size--;

        return deleteNode.element;
    }

    public void clear() {
        DoubleListNode<E> node = head;
        while (head != null) {
            node = head.next;
            head.prev = head.next = null;
            head = node;
        }
        node = null;
        tail.prev = tail.next = null;
        size = 0;
    }

    public void display() {
        DoubleListNode<E> newNode = head;
        for (int i = 0; i < size; i++) {
            System.out.print(" <--" + newNode.element + " --> ");
            newNode = newNode.next;
        }
    }

    public E get(int index) {
        DoubleListNode<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.element;
    }
}
