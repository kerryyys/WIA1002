package LAB6;

import java.util.Stack;

public class palindrome {
    public static void main(String[] args) {
        String[] words = {"abba", "aba", "Hello", "pliooilp", "lol", "T_T"};
		for(String word : words) {
			System.out.printf("%10s is palindromic string: %b\n", word, check(word));

        }
    }
    
    public static boolean check(String str){
        Stack<Character> stack = new Stack<>();
        int mid = str.length()/2; //str.length() >>1
        
        for(int i=0;i<mid;i++){
            stack.push(str.charAt(i));
        }
        for(int i=mid+(mid & 1);i<str.length();i++){
            if( !(str.charAt(i)== stack.pop()))
        return false;
        }
        
        return true;
    }
}
//mid + (mid & 1) computes the index at which the loop should start. 
//The & operator performs a bitwise AND operation on the two operands, which in this case is mid and 1.
//if mid = even, LSB =0, so (mid & 1) =0; so mid+(mis&1) = mid, loop start at mid;
//if mid=odd, LSB is 1, mid&1 = 1, so mid+mid+1= mid+1,loop start at mid+1