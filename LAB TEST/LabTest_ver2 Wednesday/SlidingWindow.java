import java.util.*;

public class SlidingWindow {
    public static int[] findMaxSlidingWindow(int[] arr, int k) {
        if(arr == null || k < 0 || arr.length < 0)
        return new int [0];

        int n = arr.length;
        int [] result = new int[n - k +1];
        int resultIndex = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i<k; i++){
            maxHeap.offer(arr[i]);
        }
        result[resultIndex++] = maxHeap.peek();
        for(int i = k; i<n; i++){
            maxHeap.remove(arr[i - k]);
            maxHeap.offer(arr[i]);
            result[resultIndex++] = maxHeap.peek();
        }
        return result;

    }

    public static void main(String[] args) {
        int[] arr = { 4, 3, 8, 9, 0, 1 };
        int k = 3;

        int[] result = findMaxSlidingWindow(arr, k);
        System.out.println("Output: " + Arrays.toString(result));

        int[] arr2 = { 9, 8, 6, 4, 3, 1 };
        int k2 = 4;

        int[] result2 = findMaxSlidingWindow(arr2, k2);
        System.out.println("Output: " + Arrays.toString(result2));

        int[] arr3 = { 1, 2, 3, 4, 10, 6, 9, 8, 7, 5 };
        int k3 = 3;

        int[] result3 = findMaxSlidingWindow(arr3, k3);
        System.out.println("Output: " + Arrays.toString(result3));
    }
}
