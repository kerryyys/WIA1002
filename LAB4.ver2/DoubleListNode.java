package LinkedList;

public class DoubleListNode<E> {
    E element;
    DoubleListNode<E> next;
    DoubleListNode<E> prev;

    public DoubleListNode(E element, DoubleListNode next, DoubleListNode prev){
        this.element = element;
        this.next = next;
        this.prev = prev;
    }

    public DoubleListNode(E element){
        this(element, null, null);
    }

    public E getElement(){
        return this.element;
    }
}
