package LAB6;
import java.util.Scanner;
public class TestIntMyStack {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    MyStack<Integer> stack = new MyStack<>();

    System.out.println("Enteran integer value");
    int value = sc.nextInt();
    sc.close();

    for(int i=1;i<=value;i++){
        stack.push(i);
    }
        System.out.println("Size of stack: "+ stack.getSize());
    
        System.out.println("\nThe contents of the stack by repeatedly calling pop()");
    while(! stack.isEmpty() ) {
        System.out.print(stack.pop()+" ");
    }
        
    }
}
 // Output: n = user entered value n-1 n-2 ... 2 1
        // Order: Descending order
        // Reason: Stack is a last in, first out (LIFO) data structure.
        //         Therefore, the larger numbers are popped first as they are pushed later than the smaller numbers.
    