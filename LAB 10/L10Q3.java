/*Q3-In the test program, display the values of array, arr after the sorting operation. 
Ensure that you invoke both implemented
selectionSortSmallest(int[] arr) and selectionSortLargest(int[] arr) to reorder
the values. */
public class L10Q3 {
        public static void main(String[] args){
            int[] arr = {45,7,2,8,19,3};
        L10Q2.SelectionSortLargest(arr);
        System.out.println("Sort from largest");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }

        L10Q1.SelectionSortSmallest(arr);
        System.out.println("Sort from smallest");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }

}
