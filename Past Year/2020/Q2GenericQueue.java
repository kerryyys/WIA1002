package py2020;
import java.util.*;
public class Q2GenericQueue<E> {
    private LinkedList<E> queue;
    private int size;
    private int maxsize;
    
    public Q2GenericQueue(int size){
        maxsize =size;
        queue = new LinkedList<>();
    }
    
    public boolean isEmpty(){
        return size==0;
    }
    
    public boolean isFull(){
        return size==maxsize;
    }
    
    public E peek(){
        return queue.getFirst();
    }
    
    public void enqueue(E e){
        queue.addLast(e);
        size++;
        System.out.println("Enqueue: "+ e);
    }
    
    public void enqueueMany(String e){
        String[] element = e.split(",");
        int i=0;
        while(i<element.length){
        enqueue((E)element[i]);
        i++;
        }
    }
    
    public void dequeue(){
        E temp = queue.removeFirst();
        size--;
        System.out.println("Dequeue: "+temp);
    }
    
    public void dequeueAll(){
        System.out.println("There are "+size+" items in the queue. Removing them all.");
        while(!isEmpty()){
            dequeue();
        }
    }
    
    public void changeOrder(int k){
        System.out.println("\nChange queue order");
        while(k<size){
        E temp = queue.removeFirst();
        queue.addLast(temp);
        k++;
        }
    }
    
    public void display(){
        if(isEmpty()){
            System.out.println("Nothing to display.\n");
            return;
        }
        int i=0;
        System.out.println("\nThere are "+size+" items in the queue. Displaying...");
        while(i<size){
        System.out.print(queue.get(i) + " | ");
        i++;
        }
        System.out.println("");
        
    }
}
