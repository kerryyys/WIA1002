import java.util.NoSuchElementException;

public class SList <E>{
    SNode<E> head;
    SNode<E> tail;
    int size;
    public void appendEnd(E e){
        SNode<E> newNode= new SNode<E>(e);
        if(tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;  //=newNode bcuz already assign next=null in SNode
            tail = newNode;  //assign e to tail
        }
        size++;
    }
    public E removeInitial(){
        if(head == null)
            throw new NoSuchElementException();

        E elem = head.e;

        if(head.equals(tail)){
            head = tail = null;
        }
        else{
            head = head.next;
        }
        size--;
        return elem;
    }
    public boolean contain(E e){
        for(SNode<E> current = head; current != null; current = current.next){
            if(current == e || current.e.equals(e)){
                return true;
            }
        }
        return false;
    }
    public void clear(){
    SNode<E> temp = head;
    while(temp != null){
        SNode<E> node=temp.next;
        temp.prev = temp.next = null;
        temp = node;
    }
    head = tail = null;
    size = 0;
    }
    public void display(){
        System.out.println("Element(s) in the list: ");
        SNode<E> current=head;
        for(int i=0;i<size;i++){
            System.out.print(current.e + " ");
            current=current.next;
        }
        System.out.println();
    }
}
