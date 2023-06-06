/*Q4- Suppose you have an integer array of eight elements (10,34,2,56,7,67,88,42). 
Your task is to sort this array in ascending order using the insertion sort algorithm. */

public class L10Q4 {
    public static void main(String[] args) {
     int[] array = {10,34,2,56,7,67,88,42};
        InsertionSort(array);
        for(int i = 0; i<array.length; i++)
        System.out.println(array + " ");
    }
    public static void InsertionSort(int[] array) {
        for(int i = 1; i< array.length; i++){
            int currentElement = array[i];
            int k;
            for(k = i-1; k>=0 && array[k] > currentElement; k--){
                array[k+1] = array[k];
            }
            array[k+1] = currentElement;
        }
    }
}