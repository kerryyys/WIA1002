package LinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E extends Comparable<E>> {

    private ListNode<E> head;
    private ListNode<E> tail;
    private E element;
    private int size;

    public void addFirst(E o) {
        ListNode<E> node = new ListNode<>(null, o, head);
        head = node;
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    public void addLast(E o) {
        ListNode<E> node = new ListNode<>(null, o, null);

        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    public E getFirst() {
        return head.element;
    }

    public E getLast() {
        return tail.element;
    }

    public E removeFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        E temp = head.element;
        head = head.next;

        if (head == null)
            tail = null;

        size--;
        return temp;
    }

    public E removeLast() {
        if (tail == null) {
            throw new NoSuchElementException();
        }
        E temp = tail.element;
        tail = tail.prev;
        if (tail == null)
            head = null;

        size--;
        return temp;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        ListNode<E> nodeToRemove;

        if (index == 0) {
            nodeToRemove = head;
            head = head.next;
            if (head == null) {
                tail = null;
            } else {
                head.prev = null;
            }
        } else if (index == size - 1) {
            nodeToRemove = tail;
            tail = tail.prev;
            tail.next = null;
        } else {
            ListNode<E> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            nodeToRemove = current;
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }

        size--;
        return nodeToRemove.element;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        ListNode<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        return current.getElement();
    }

    public void addSortNode(E o) {
        ListNode<E> newNode = new ListNode<>(null, o, null);

        if (isEmpty()) {
            addFirst(o); // If the list is empty, simply add the element as the first node
            return;
        }

        ListNode<E> current = head;
        ListNode<E> previous = null;

        while (current != null && current.element.compareTo(o) < 0) { // find correct position
            previous = current;
            current = current.next;
        }

        if (previous == null) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else {
            newNode.next = current;
            previous.next = newNode;
            newNode.prev = previous;

            if (current != null) {
                current.prev = newNode;
            } else {
                tail = newNode;
            }
        }

        size++;
    }
    /*
     * Create a new ListNode object, newNode, with the provided element o and set
     * its prev and next references to null.
     * Check if the list is empty using the isEmpty() method. If it is empty, simply
     * add the element as the first node using the addFirst() method, as the list is
     * guaranteed to be sorted.
     * 
     * If the list is not empty, traverse through the list to find the correct
     * position to insert the new node. We compare the element of each node with the
     * new element o. If we find a node with an element greater than o, we break out
     * of the loop, as we have found the correct position.
     * 
     * Once we have found the correct position, we update the references
     * accordingly:
     * If previous is null, it means the new node should be inserted at the
     * beginning of the list. In this case, we update the references of newNode,
     * head, and the previous head node accordingly.
     * If previous is not null, it means the new node should be inserted somewhere
     * in the middle or at the end of the list. In this case, we update the
     * references of newNode, previous, current, and the next node accordingly.
     * Finally, increment the size of the list to keep track of the number of
     * elements.
     */

    public void splitList() {
        LinkedList<E> list1 = new LinkedList<>();
        LinkedList<E> list2 = new LinkedList<>();

        ListNode<E> current = head;
        int count = 0;
        while (current != null) {
            if (count < (size + 1) / 2) {
                list1.addLast(current.getElement());
            } else {
                list2.addLast(current.getElement());
            }
            current = current.getNext();
            count++;
        }

        list1.displayList("First list");
        list2.displayList("Second list");
    }

    public LinkedList<E> mergeList() {
        LinkedList<E> list1 = new LinkedList<>();
        LinkedList<E> list2 = new LinkedList<>();

        ListNode<E> current = head;
        int count = 0;
        while (current != null) {
            if (count % 2 == 0) {
                list1.addLast(current.getElement());
            } else {
                list2.addLast(current.getElement());
            }
            current = current.getNext();
            count++;
        }

        LinkedList<E> mergedList = new LinkedList<>();
        ListNode<E> node1 = list1.getHead();
        ListNode<E> node2 = list2.getHead();
        while (node1 != null || node2 != null) {
            if (node1 != null) {
                mergedList.addLast(node1.getElement());
                node1 = node1.getNext();
            }
            if (node2 != null) {
                mergedList.addLast(node2.getElement());
                node2 = node2.getNext();
            }
        }

        return mergedList;
    }

    public void alternateList() {
        LinkedList<E> list1 = new LinkedList<>();
        LinkedList<E> list2 = new LinkedList<>();

        ListNode<E> current = head;
        int count = 0;
        while (current != null) {
            if (count % 2 == 0) {
                list1.addLast(current.getElement());
            } else {
                list2.addLast(current.getElement());
            }
            current = current.getNext();
            count++;
        }

        list1.displayList("First list");
        list2.displayList("Second list");
    }

    public void reverseList() {
        head = recursiveReverse(head);
    }

    private ListNode<E> recursiveReverse(ListNode<E> current) {
        if (current == null || current.getNext() == null) {
            return current;
        }

        ListNode<E> nextNode = current.getNext();
        current.setNext(null);
        ListNode<E> reversedList = recursiveReverse(nextNode);
        nextNode.setNext(current);
        return reversedList;
    }

    public void displayList(String listName) {
        System.out.print(listName + ": ");
        ListNode<E> current = head;
        while (current != null) {
            System.out.print(current.getElement() + " --> ");
            current = current.getNext();
        }
        System.out.println();
    }

    public ListNode<E> getHead() {
        return head;
    }

    public Iterator<E> listIterator() {
        return new LinkedListIterator();
    }

    @Override
    public String toString() {
        if (head == null) {
            return "LinkedList is empty.";
        }

        StringBuilder sb = new StringBuilder();
        ListNode<E> currentNode = head;

        while (currentNode != null) {
            sb.append(currentNode.getElement());
            if (currentNode.getNext() != null) {
                sb.append(" --> ");
            }
            currentNode = currentNode.getNext();
        }

        return sb.toString();
    }

    private class LinkedListIterator implements Iterator<E> {
        private ListNode<E> current = head;
        private ListNode<E> previous = null;
        private boolean removeFlag = false;

        public boolean hasNext() {
            return current != null;
        }

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No next element in the iterator");
            }
            E element = current.element;
            previous = current;
            current = current.next;
            removeFlag = true;
            return element;
        }

        @Override
        public void remove() {
            if (current == null) {
                throw new IllegalStateException("Cannot call remove() after reaching the end of the list");
            }

            ListNode<E> previous = current.prev;
            ListNode<E> next = current.next;

            if (previous != null) {
                previous.next = next;
            } else {
                // Removing the first element
                head = next;
            }

            if (next != null) {
                next.prev = previous;
            } else {
                // Removing the last element
                tail = previous;
            }

            // Update the current reference if it was pointing to the removed node
            if (current == tail) {
                current = previous;
            }

            size--;
        }
    }

   public void removeWordsWithCharacter(char c) {
    Iterator<E> iterator = listIterator();
    while (iterator.hasNext()) {
        E element = iterator.next();
        String word = element.toString();
        if (word.contains(Character.toString(c))) {
            iterator.remove();
        }
    }
}
}