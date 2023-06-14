package LabTest;

import java.util.PriorityQueue;
import java.util.Arrays;

public class SlidingWindow {
    public static void main(String[] args){
        int [] arr1 = new int[]{4,3,8,9,0,1};
        int k1 = 3;

        int[] arr2 = new int[]{9,8,6,4,3,1};
        int k2 = 4;

        int[] arr3 = new int[]{1,2,3,4,10,6,9,8,7,5};
        int k3 = 3;

        System.out.println("Input arr[]: "+Arrays.toString(arr1) + " k = "+k1);
        System.out.println(minimum(arr1,k1));
        System.out.println("Input arr[]: "+Arrays.toString(arr2) + " k = "+k2);
        System.out.println(minimum(arr2, k2));
        System.out.println("Input arr[]: "+Arrays.toString(arr3) + " k = "+k3);
        System.out.println(minimum(arr3, k3));
    }

    public static String minimum(int[] arr, int k){
        int size = arr.length - k + 1;
        int[] array = new int[size];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        //add first 'k' elements to pq
        for(int i=0; i<k; i++){
            pq.add(arr[i]);
        }
        array[0] = pq.peek();

        //process the remaining elements using sliding window approach
        for(int i=k; i<arr.length; i++){
            pq.remove(arr[i-k]);
            pq.add(arr[i]); //remove the outgoing element from the window
            array[i - k + 1] = pq.peek(); //add incoming element to window
        }
        return Arrays.toString(array);
    }
}
