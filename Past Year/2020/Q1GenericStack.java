package py2020;

import java.util.*;

public class Q1GenericStack<E> {

    private int size;
    private int maxsize;
    private ArrayList<E> stack;

    public Q1GenericStack() {
        size = 0;
        stack = new ArrayList<>();

    }

    public Q1GenericStack(int size) {
        maxsize = size;
        stack = new ArrayList<>(size);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == maxsize;
    }

    public E peek() {
        return stack.get(size - 1);
    }

    public void push(E e) {
        stack.add(e);
        size++;
        System.out.println("Push: " + peek());
    }

    public void pushMany(String e) {
        System.out.println("\nPush many into stack...");
        String[] element = e.split(",");
        for (int i = 0; i < element.length; i++) {
            stack.add((E) element[i]);
            size++;
            System.out.println("Push: " + peek());
        }
    }

    public E pop() {
        E temp = stack.remove(size - 1);
        size--;
        return temp;
    }

    public E popMiddle() {
        if (size % 2 == 0) {
            System.out.println("\nCurrent count of stack is even number, so no middle index.");
            return null;
        }
        int middle = (size + 1) / 2;
        E temp = stack.remove(middle-1);
        size--;
        return temp;
    }

    public void popAll() {
        System.out.println("\nThere are " + size + " items in the stack. Pop all...");
        while (!isEmpty()) {
            E temp = stack.remove(size - 1);
            System.out.println("Removing " + temp);
            size--;
        }
        System.out.println("");
        if (isEmpty()) {
            System.out.println("Stack is empty. Nothing to display.");

        }
    }

    public void display() {
        System.out.println("\nThere are " + size + " items in the stack. Displaying all...");
        for (int i = size-1; i >=0; i--) {
            System.out.println(stack.get(i));
        }
    }

}
