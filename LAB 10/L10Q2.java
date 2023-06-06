/*Q2-Modify your answer in Q1 so that it uses the largest value in the list in
Step1 and 3 of the search strategy. The method signature is given as
public void selectionSortLargest(int[] arr) */

public class L10Q2 {

    public static void SelectionSortLargest(int[] list){
        for(int i=0; i<list.length-1;i++){
            int currentMax = list[i];
            int currentMaxIndex = i;
    
            for(int j = i+1; j<list.length;j++){
                if(currentMax < list[j]){
                    currentMax = list[j];
                    currentMaxIndex = j;
                }
            }
    
            if(currentMaxIndex != i){
                list[currentMaxIndex] = list[i];
                list[i] = currentMax;
            }
        }
    }
}
