package LAB6;

import java.util.ArrayList;

public class MyStack<E> {
    public ArrayList<E> list;

    public MyStack(){
        list = new ArrayList<E>();
    }
   
    public void push(E o){
        list.add(o);
    }
    public E pop(){
        return list.remove(getSize()-1);
    }
    public E peek(){
        return list.get(getSize()-1);
    }
    public int getSize(){
        return list.size();
    }
    public boolean isEmpty(){
        return list.isEmpty();
    }
    @Override
    public String toString(){
        return "stack: "+list.toString();
    }
    public boolean search(E o){
        return list.contains(o);
    }
}
