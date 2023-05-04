/* Write a test program that :
a. Have an initialize queue items consists of Durian and Blueberry in a fruitQ
b. Then add new items in the following order: Apple, Orange, Grapes, Cherry.
c. Display the queue.
d. Show the top item.
e. Get the queue size.
f. Delete Durian.
g. Get item in index position of 2
h. Check whether the queue consists of Cherry
i. Check whether the queue consists of Durian
j. Display the queue using the isEmpty() condition. */
package LAB7;

public class MyQueueTest {
    public static void main(String[] args) {
        //a
        MyQueue<String> fruitQ = new MyQueue<String>(new String[]{"Durian", "Blueberry"});
        
        //b
        fruitQ.enqueue("Apple");
        fruitQ.enqueue("Orange");
        fruitQ.enqueue("Grapes");
        fruitQ.enqueue("Cherry");

        //c
        System.out.println(fruitQ.toString());

        //d
        System.out.println("Top item: " + fruitQ.peek());

        //e
        System.out.println("Size: " + fruitQ.getSize());

        //f
        fruitQ.dequeue();

        //g
        System.out.println("Item in index position of 2: " + fruitQ.getElement(2));

        //h
        System.out.println("Cherry in fruitQ?" + fruitQ.contains("Cherry")); 

        //i
        System.out.println("Durian in fruitQ?" + fruitQ.contains("Durian"));

        //j
        System.out.println("Queue is Empty?  " + fruitQ.isEmpty());
    }
}
