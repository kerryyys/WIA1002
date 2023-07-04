package py2020;
import java.util.*;
public class Q1 {
    public static void main(String[] args){
        Q1GenericStack<String> stack1 = new Q1GenericStack<String>();
        stack1.push("apple");
        stack1.display();
        stack1.pushMany("broccoli,chicken sandwich,donut,french fries,juice,maruku");
        stack1.display();
        System.out.println("Pop the top of the stack: " + stack1.pop());
        System.out.println("Pop the top of the stack: " + stack1.pop());
        stack1.display();
        System.out.println("Pop the middle of the stack: " + stack1.popMiddle());
        stack1.display();
        
        System.out.println("Pop the middle of the stack: " + stack1.popMiddle());
        System.out.println("---------------------------------------------------------");
        
        Q1GenericStack<Integer> stack2 = new Q1GenericStack<Integer>(10);
        stack2.push(1);
        stack2.push(2);
        stack2.pushMany("3 4,5,6 7");
        stack2.display();
        stack2.popAll();
        stack2.display();
    }
    
    
}
