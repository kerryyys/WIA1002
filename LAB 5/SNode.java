public class SNode<E> {
    //no private so other class can use
    E e;
    SNode<E> next;
    SNode<E> prev;

    SNode(){
        this(null,null);
    }
    SNode(E e){
        this.e=e;
    }
    SNode(E e,SNode<E>next){
        this.e=e;
        this.next=next;
    }
}
