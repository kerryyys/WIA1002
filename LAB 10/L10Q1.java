/*Selection sort orders a list of values by repetitively putting a particular value into its final position. 
The search strategy is as follows:
1. Scan list, find the smallest value in the list
2. Switch it with the value in the first position
3. Find the next smallest value in the list
4. Switch it with the value in the second position
5. Repeat until all values are in their proper places
Given the following array,
arr = {45, 7, 2, 8, 19, 3}
Q1-Implement selection sort according to the search strategy shown above.
The method signature is given as:
public void selectionSortSmallest(int[] arr) */

public class L10Q1{
public static void SelectionSortSmallest(int[] list){
    for(int i=0; i<list.length-1;i++){
        int currentMin = list[i];
        int currentMinIndex = i;

        for(int j = i+1; j<list.length;j++){
            if(currentMin > list[j]){
                currentMin = list[j];
                currentMinIndex = j;
            }
        }

        if(currentMinIndex != i){
            list[currentMinIndex] = list[i];
            list[i] = currentMin;
        }
    }
}
}
