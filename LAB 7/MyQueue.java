/*a) Write a generic queue class called MyQueue using LinkedList. Implement the following methods:
a. public MyQueue(E[] e)
b. public MyQueue()
c. public void enqueue(E e)
d. public E dequeue()
e. public E getElement(int i)
f. public E peek()
g. public int getSize()
h. public boolean contains(E e)
i. public boolean isEmpty();
j. public String tostring() */

package LAB7;

import java.util.LinkedList;

public class MyQueue<E> {
    
    protected LinkedList<E> list = new LinkedList<>();
    
    public MyQueue(){}

    public MyQueue(E[] e){
        for(E element : e)
        this.list.addLast(element);
    }

    public void enqueue(E e){
        list.addLast(e);
    }
    
    public E dequeue(){
        return list.removeFirst();
    }

    public E getElement(int i){
        if (isEmpty()) {
            return null;
        }
        return list.get(i);
    }

    public E peek(){
        return list.getFirst();
    }

    public int getSize(){
        return list.size();
    }

    public boolean contains(E e){
        return list.contains(e);
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public String toString(){
        return "Queue: "+list.toString();
    }
}
