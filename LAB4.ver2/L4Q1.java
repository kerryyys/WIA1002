package LinkedList;

import java.util.Random;
public class L4Q1 {
    public static void main(String [] args){
    Random rand = new Random();
    LinkedList<Integer> frontlist = new LinkedList<>();
    LinkedList<Integer> backlist = new LinkedList<>();
    LinkedList<Integer> sortedList = new LinkedList<>();

    System.out.print("The random numbers are : ");
    for(int i=0;i<10;i++){
        int num = rand.nextInt(0,101);
        backlist.addLast(num);
        frontlist.addFirst(num);
        sortedList.addSortNode(num);
        System.out.print(num + " --> ");
    }
    
    System.out.println("\nInsert the random numbers at the back of the linked list");
    while(!backlist.isEmpty())
    System.out.print(backlist.removeFirst() + " --> ");
    
    System.out.println("\nInsert the random numbers int front of the linked list");
    while(!frontlist.isEmpty()){
        System.out.print(frontlist.removeFirst() + " --> ");
    }

    System.out.println("\nInsert the random numbers in a sorted linked list");
    while(!sortedList.isEmpty()){
        System.out.print(sortedList.removeFirst() + " --> ");
    }
}
}
