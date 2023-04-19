public class Node<E> {
    E element;
    Node<E> next;
    Node<E> prev;
    Node(E e){
        this(e,null,null);
    }

    Node(E element, Node<E> prev,Node<E> next){
        this.element =element;
        this.next=next;
        this.prev=prev;
    }
}
