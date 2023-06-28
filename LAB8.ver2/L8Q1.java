package sorting;
import java.util.*;
public class L8Q1 {
    public static void main(String[] args){
        Random rand = new Random();
        Scanner sc= new Scanner(System.in);
        
        System.out.println("Enter N Special Random Number within 0-100:");
        int N = sc.nextInt();
        int[] list = new int[N];
        System.out.println("The Special Number are: ");
        for (int i = 0; i < N; i++) {
            list[i]= rand.nextInt(101);
            System.out.print(list[i] + " ");
        }
         
        System.out.println("\nAfter Merge Sort: ");
        mergeSort(list);
        
        int[] arrangedList = new int[list.length];
        int index = 0;
        int index2 = 0;
        for(int i=0;i<list.length;i++){
            if(list[i] % 2 != 0){
                arrangedList[index++] = list[i];
                index2 = index;
            }
        }
        for(int i=0;i<list.length;i++){
            if(list[i] % 2 == 0){
                arrangedList[index2++] = list[i];
            }
        }
        
        for(int i=0;i<arrangedList.length;i++){
            System.out.print(arrangedList[i] + " ");
        }
        
    }
    
    public static void mergeSort(int [] arrangedList){
       
        if(arrangedList.length>1){
            int[] left = new int[arrangedList.length/2];
            System.arraycopy(arrangedList, 0, left, 0, arrangedList.length/2);
            mergeSort(left);
            
            int rightLength = arrangedList.length-arrangedList.length/2;
            int[] right = new int[rightLength];
            System.arraycopy(arrangedList, arrangedList.length/2, right, 0, rightLength);
            mergeSort(right);
            
            merge(left, right, arrangedList);
        }
    }
    
    
    public static void merge(int [] left, int [] right, int [] list){
        int leftIndex = 0;
        int rightIndex = 0;
        int listIndex = 0;
        
        while(leftIndex < left.length && rightIndex < right.length){
            if(left[leftIndex] < right[rightIndex])
                list[listIndex++] = left[leftIndex++];
                else
                list[listIndex++] = right[rightIndex++];
        }
        
        while(leftIndex < left.length)
            list[listIndex++] = left[leftIndex++];
        
        while(rightIndex < right.length)
            list[listIndex++] = right[rightIndex++];
    }
}