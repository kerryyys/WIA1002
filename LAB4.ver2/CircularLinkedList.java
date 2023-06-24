package LinkedList;

public class CircularLinkedList<E extends Comparable<E>> {
    int length;
    ListNode<E> head;
    ListNode<E> tail;

    public int length() {
        return this.length;
    }

    public void addCircularNode(E o) {
        ListNode<E> newNode = new ListNode<>(o, head);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        length++;
    }

    public void deleteCircularNode() {
    if (head == null) {
        throw new IllegalStateException("CircularLinkedList is empty.");
    }

    if (head == tail) {
        head = null;
        tail = null;
        length = 0;
        return;
    }

    ListNode<E> currentNode = head;
    ListNode<E> previousNode = tail;

    while (currentNode != tail) {
        previousNode = currentNode;
        currentNode = currentNode.getNext();
    }

    previousNode.setNext(head);
    tail = previousNode;
    length--;
}

   public void showCircularList() {
    if (head == null) {
        System.out.println("CircularLinkedList is empty.");
        return;
    }

    ListNode<E> currentNode = head;
    int count=0;

   while(count <length+1){
        System.out.print(currentNode.getElement() + " --> ");
        currentNode = currentNode.getNext();
    count++;
   }
    System.out.println();
}


    public E getCircularItem(int index) {
        if (index >= length || index < 0) {
            return null;
        }
        ListNode<E> currentNode = head;
        for (int i = 0; i < length; i++) {
            if (i == index) {
                return currentNode.getElement();
            } else {
                currentNode = currentNode.getNext();
            }
        }
        return null;
    }
}
