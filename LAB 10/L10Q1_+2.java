package sorting;
import java.util.*;
public class L10Q1 {
    
    public static void main(String[] args){
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array: ");
        int N = sc.nextInt();
        int[] arr = new int[N];
        System.out.println("The random number generated are: ");
        for(int i=0;i<N;i++){
            arr[i] = rand.nextInt(100);
            System.out.print(arr[i] + " ");
        }
        selectionSortSmallest(arr);
        System.out.println("\nSort from the smallest");
        for(int i=0;i<arr.length;i++){
        System.out.print(arr[i] + " ");
        }
        
        selectionSortLargest(arr);
        System.out.println("\nSort from the largest");
        for(int i=0;i<arr.length;i++){
        System.out.print(arr[i] + " ");
        }
    }
    
    public static void selectionSortSmallest(int [] arr){
        
        for(int i=0;i<arr.length-1;i++){
            int min = arr[i];
            int currentIndex = i;
            for(int j =i+1;j<arr.length;j++){
                if(min > arr[j]){
                    min = arr[j];
                    currentIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = min;
            arr[currentIndex] = temp;
            
            //Alternative, shorter
//            if(currentIndex != i){
//                arr[currentIndex] = arr[i];
//                arr[i] = min;
//            }
        }
    }
    
    public static void selectionSortLargest(int [] arr){
        
        for(int i=0;i<arr.length-1;i++){
            int max = arr[i];
            int currentIndex = i;
            for(int j =i+1;j<arr.length;j++){
                if(max < arr[j]){
                    max = arr[j];
                    currentIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = max;
            arr[currentIndex] = temp;
        }
    }
    
    
}
