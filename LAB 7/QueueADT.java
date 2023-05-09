package LAB7;
import java.util.PriorityQueue;
import java.util.Collections;

public class QueueADT<E> {
    public static void main(String[] args) {
        int [] array={4,8,1,2,9,6,3,7};
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i : array) {
            pq.add(i);
        }
        System.out.println("Elements in priority queue: "+pq.toString());

        System.out.println("First element is removed from the priority queue");
        pq.poll();
        System.out.println(pq.toString());

        System.out.println("Adding 5 to the priority queue...");
        pq.add(5);
        System.out.println(pq.toString());

        // Convert the priority queue into an array and display
        Object[] arr = pq.toArray();
        System.out.print("Priority queue as an array: ");
        for (Object obj : arr) {
            System.out.print(obj + " ");
        }
        System.out.println();

        System.out.println("First element in priority queue: "+pq.peek());

        System.out.println("Does the queue contains 1? "+pq.contains(1));

        System.out.println("Size of the priority queue: "+ pq.size());

        // Remove elements from the priority queue until it is empty
        System.out.print("Removing elements from priority queue: ");
        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }
        System.out.println();

        // Reversing the priority queue
        PriorityQueue<Integer> reversedPq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < array.length; i++) {
            reversedPq.add(array[i]);
        }
        System.out.println("Reversed priority queue: " + reversedPq.toString());
    }
}
