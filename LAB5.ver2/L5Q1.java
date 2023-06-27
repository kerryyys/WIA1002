/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stack;
import java.util.*;
public class L5Q1 {
    public static void main(String[] args) {
        Stack<String> candy = new Stack<String>();
        Random rand = new Random();
        int size = rand.nextInt(11);
        LinkedList<String> colour = new LinkedList<String>();
        colour.add("Blue");
        colour.add("Orange");
        colour.add("Red");
        colour.add("Yellow");
        for(int i=0;i<size;i++){
            candy.push(colour.get(rand.nextInt(4)));
        }
        Stack<String> container = new Stack<String>();
        
        System.out.println("The candies in the container:");
        for(int i=0;i<size;i++){
        System.out.print(" <-- " + container.push(candy.pop()));
        }
        
        for(int i=0;i<size;i++){
            candy.push(container.pop());
        }
        System.out.println("\nThe candies in the container:");
        for(int i=0;i<size;i++){
            if(!candy.peek().equals("Blue")){
                System.out.print(" <-- " + container.push(candy.pop()));
            }
            else{
                candy.pop();
            }
        }
        
    }
}
