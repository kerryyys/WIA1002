/*Create two priority queues with the following elements: {"George", "Jim", "John",
"Blake", "Kevin", "Michael"} and {"George", "Katie", "Kevin", "Michelle", "Ryan"}.
Find their union, difference, and intersection. */
package LAB7;
import java.util.PriorityQueue;
//java.util.Set = already have the method for these 3
public class L7bQ2 {
    public static void main(String[] args) {
    String [] queue1 = {"George", "Jim", "John","Blake", "Kevin", "Michael"};
    String [] queue2 = {"George", "Katie", "Kevin", "Michelle", "Ryan"};
    PriorityQueue<String> pq1 = new PriorityQueue<>();
    PriorityQueue<String> pq2 = new PriorityQueue<>();


    for (String i : queue1) {
            pq1.add(i);
        }
    for (String i : queue2) {
            pq2.add(i);
        }

        // Union
        PriorityQueue<String> union = new PriorityQueue<>(pq1);
        union.addAll(pq2);
        System.out.println("Union: " + union);

        // Difference 
        //only the elements that are in the first set but not in the second set
        PriorityQueue<String> difference = new PriorityQueue<>(pq1);
        difference.removeAll(pq2);
        System.out.println("Difference[Set 1 to Set 2]: " + difference);

        PriorityQueue<String> difference2 = new PriorityQueue<>(pq2);
        difference2.removeAll(pq1);
        System.out.println("Difference[Set 2 to Set 1]: " + difference2);
        
        // Intersection
        PriorityQueue<String> intersection = new PriorityQueue<>(pq1);
        intersection.retainAll(pq2);
        System.out.println("Intersection: " + intersection);
}
    }
