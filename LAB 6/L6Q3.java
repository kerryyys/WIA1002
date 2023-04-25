package LAB6;

import java.util.Stack;
import java.util.Random;

public class L6Q3 <E> {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
		Random random = new Random();
		for(int i = 0; i < 10; i++) {
			stack.push(random.nextInt(101));
		}
		System.out.println(stack);
		System.out.println("Sum is: " + sum(stack));
	}
	
	 public static int sum(Stack<Integer> stack) { //called from other classes without having to create an instanc
		int sum = 0;
		while(!stack.isEmpty()) 
			sum += stack.pop();
		return sum;
	}
    

    
}

