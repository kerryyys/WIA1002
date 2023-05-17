package LAB7;
import java.util.PriorityQueue;
import java.util.Collections;

public class QueueADT<E> {
    public static void main(String[] args) {

        int [] array={4,8,1,2,9,6,3,7};
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i : array) {
            pq.offer(i);
        }
        
        System.out.println("Elements in priority queue: "+pq.toString());

        System.out.println("\nFirst element which is removed from the priority queue: " + pq.poll());
        System.out.println("\n" + pq.toString());

        System.out.println("\nAdding 5 to the priority queue...");
        pq.offer(5);
        System.out.println(pq.toString());

        // Convert the priority queue into an array and display
        Object[] arr = pq.toArray();
        System.out.print("\nPriority queue as an array: ");
        for (Object obj : arr) {
            System.out.print(obj + " ");
        }
        System.out.println();

        System.out.println("\nFirst element in priority queue: "+pq.peek());

        System.out.println("\nDoes the queue contains 1? "+pq.contains(1));

        System.out.println("\nSize of the priority queue: "+ pq.size());

        // Remove elements from the priority queue until it is empty
        System.out.print("\nRemoving elements from priority queue: ");
        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }
        System.out.println();

        // Reversing the priority queue
        PriorityQueue<Integer> reversedPq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < array.length; i++) {
            reversedPq.offer(array[i]);
        }
        while (!reversedPq.isEmpty()) { //to print in order
            System.out.print(reversedPq.poll() + " ");
        }

        // System.out.println("Reversed priority queue: " + reversedPq.toString());
    }
}
