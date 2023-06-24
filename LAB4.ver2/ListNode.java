package LinkedList;
//L4Q1
public class ListNode<E extends Comparable<E>> {
    E element;
    ListNode<E> next;
    ListNode<E> prev;

    public ListNode(ListNode<E> prev, E e, ListNode<E> next){
        this.prev = prev;
        this.element =e;
        this.next = next;
    }

     public ListNode(E element, ListNode<E> next) {
            this.element = element;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public ListNode<E> getNext() {
            return next;
        }

        public void setNext(ListNode<E> next) {
            this.next = next;
        }
}
