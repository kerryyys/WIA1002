/*Q4- Suppose you have an integer array of eight elements (10,34,2,56,7,67,88,42). 
Your task is to sort this array in ascending order using the insertion sort algorithm. */

public class L10Q4 {
    public static void main(String[] args) {
     int[] array = {10,34,2,56,7,67,88,42};
        InsertionSort(array);
        for(int i = 0; i<array.length; i++)
        System.out.print(array[i] + " ");
    }
    public static void InsertionSort(int[] array) {
        for(int i = 1; i< array.length; i++){ //start sort from second element since we assume 1st element already sorted
            int currentElement = array[i];
            int k;
            for(k = i-1; k>=0 && array[k] > currentElement; k--){
                array[k+1] = array[k];
            }
            array[k+1] = currentElement;
        }
    }
}

/*The outer loop iterates through each element of the array, starting from the second element (index 1). We assume that the first element (index 0) is already sorted.

For each element at index i, we store its value in the currentElement variable.

The inner loop starts from the element just before the current element (k = i - 1) and continues until we reach the beginning of the array or find an element smaller than the currentElement.

In the inner loop, if we find an element greater than the currentElement, we shift it to the right by one position (array[k + 1] = array[k]).

After the inner loop finishes, we have found the correct position for the currentElement. We insert it at k + 1 (one position to the right of the last shifted element).

This process continues for each element in the array until the entire array is sorted in ascending order. */