import java.util.NoSuchElementException;

public class DoublyLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size=0;
public DoublyLinkedList(){
    this.head=null;
    this.tail=null;
}
    public void addFirst(E e){
        Node<E> temp = new Node(e, null, head);
        if(head != null) {head.prev = temp;}
        head = temp;
        if(tail == null) { tail = temp;}
        size++;
        System.out.println("adding: "+ e);
    }
    public void addLast(E e){
        Node<E> temp = new Node(e,tail,null);
        if(tail != null){ tail.next = temp;}
        tail = temp;
        if(head == null) {head = temp;}
        size++;
        System.out.println("adding: "+ e);
    }
    public void add(int index,E e){
        if(index < 0 || index > size) throw new IndexOutOfBoundsException();

        if(index == 0)
            addFirst(e);
        else if (index == size)
            addLast(e);
        else {
            Node<E> temp;
            if(index < (size+1)/2) {
                temp = head;
                for (int i = 0; i < index; i++)
                    temp = temp.next;
            }
            else{
                temp = tail;
                for(int i = size-1;i>index;i--)
                    temp = temp.prev;
            }
                Node<E> insert = new Node<>(e, temp.prev, temp);
                if (temp.prev != null)
                temp.prev.next = insert;
                temp.prev = insert;
                size++;

        }
        System.out.println("adding: "+ e);
    }
    public E removeFirst(int index){
        if (size == 0) throw new NoSuchElementException();
        Node<E> temp = head;
        head = head.next;
        head.prev = null;
        size--;
        System.out.println("deleted: "+temp.element);
        return temp.element;
    }
    public E removeLast(int index){
        if (size == 0) throw new NoSuchElementException();
        Node<E> temp = tail;
        tail = tail.prev;
        tail.next = null;
        size--;
        System.out.println("deleted: "+temp.element);
        return temp.element;
    }
    public E remove(int index){
        if(index < 0 || index >=size) throw new IndexOutOfBoundsException();
        Node<E> current;
        if(index == 0) {
            return removeFirst(index);
        }
        if(index == size-1){
            return removeLast(index);
        }
        if(index == (size +1) /2){
            current = head;
            for(int i=0;i<index;i++)
                current = current.next;
        }
        else{
            current=tail;
            for(int i=size-1;i>index;i--){
                current = current.prev;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
            current.next = current.prev = null;
            size --;
            System.out.println("delete: "+ current.element);
        }
        return current.element;
    }
    public void transverseForward(){
        System.out.println("iterating forward...");
        Node<E> temp = head;
        while(temp != null){
            System.out.print(temp.element+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    public void transverseBackward(){
        System.out.println("iterating backward...");
        Node<E> temp = tail;
        while(temp != null){
            System.out.print(temp.element+" ");
            temp = temp.prev;
        }
        System.out.println();
    }
    public void printSize(){
        System.out.println("Size of current Doubly Linked List: "+ size);
    }
    public void clear(){
        Node<E> temp=head;
        while(head != null){
            temp = head.next;
            head.prev = head.next = null;
            head = temp;
        }
        tail.prev = tail.next = null;
        System.out.printf("Successfully cleared %d nodes.\n", this.size);
        size = 0;
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> intList=new DoublyLinkedList<>();

        intList.addFirst(1);
        intList.addLast(10);
        intList.addLast(100);
        intList.add(2,2);

        intList.remove(3);

        intList.transverseForward();
        intList.transverseBackward();

        intList.printSize();
        intList.clear();
        intList.printSize();
    }
}
//still got bug in add part and iterate backward