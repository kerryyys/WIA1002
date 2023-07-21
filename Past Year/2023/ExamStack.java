import java.util.LinkedList;

public class ExamStack<E> {
    LinkedList<E> list = new LinkedList<>();

    public E peep() {
        if(list.size()==0){
            return null;
        }
        return list.getLast();
    }

    public E pop() {
        if(list.size()==0){
            return null;
        }
        return list.removeLast();
    }

    public void push(E element) {
        list.addLast(element);
    }

    public int getSize(){
        return list.size();
    }
}
