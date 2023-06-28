package sorting;
import java.util.*;
public class L10Q4 {
    public static void main(String[] args){
        int[] arr = {10,34,2,56,7,67,88,42};
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        InsertionSort(arr);
        System.out.println("\nAfter insertion sort");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    
    public static void InsertionSort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int current = arr[i];
            int k;
            for(k = i-1;k>=0 && arr[k] > current ;k--){
                arr[k+1] = arr[k];
            }
            arr[k+1] = current;//since k already -1. so need +1 again
        }
    }
}
