package sorting;
import java.util.*;
public class L8Q4 {
    public static void main(String[] args) {
        char[] randomChars = generateRandomChars(10);

        System.out.println("Before sorting:");
        System.out.println(Arrays.toString(randomChars));

        heapSort(randomChars);

        System.out.println("After sorting:");
        System.out.println(Arrays.toString(randomChars));
    }

    public static void heapSort(char[] arr) {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            char temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    public static void heapify(char[] arr, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // Left child
        int right = 2 * i + 2; // Right child

        // If left child is larger than root
        if (left < n && arr[left] > arr[largest])
            largest = left;

        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[largest])
            largest = right;

        // If largest is not root
        if (largest != i) {
            char swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    public static char[] generateRandomChars(int size) {
        char[] randomChars = new char[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            randomChars[i] = (char) (random.nextInt(26) + 'A');
        }

        return randomChars;
    }

}
