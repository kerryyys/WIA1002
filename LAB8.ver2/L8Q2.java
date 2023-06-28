package sorting;

import java.util.*;
import java.io.*;

//Bubble Sort Solution
public class L8Q2 {

    public static void main(String[] args) {
        ArrayList<String[]> product = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("lab8Q2.txt"));
            String line;
            System.out.println("Reading data from product text file");
            while ((line = reader.readLine()) != null) {
                String[] content = line.split(" : ");
                System.out.println(line);
                product.add(content);
            }

        } catch (IOException e) {
            System.out.println("File not found.");
        }
        double[] price = new double[product.size()];
        double[] PID = new double[product.size()];
        for (int i = 0; i < product.size(); i++) {
            price[i] = Double.parseDouble(product.get(i)[2]);
            PID[i] = Double.parseDouble(product.get(i)[3]);
        }

        bubbleSort(product, price, PID);

        System.out.println("After Bubble Sort(Price, PID): ");
        for (int i = 0; i < product.size(); i++) {
            System.out.println(product.get(i)[0] + " : " + product.get(i)[1] + " : " + product.get(i)[2] + " : "
                    + product.get(i)[3]);

            quickSort(product, price, PID, 0, product.size() - 1);

            System.out.println("After Quick Sort (Price, PID): ");
            for (String[] item : product) {
                System.out.println(item[0] + " : " + item[1] + " : " + item[2] + " : " + item[3]);
            }
        }
    }

    public static void bubbleSort(ArrayList<String[]> list, double[] price, double[] PID) {
        int n = list.size();
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (price[i] > price[i + 1] || (price[i] == price[i + 1] && PID[i] > PID[i + 1])) {
                    String[] temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                    double tempPrice = price[i];
                    price[i] = price[i + 1];
                    price[i + 1] = tempPrice;
                    double tempPID = PID[i];
                    PID[i] = PID[i + 1];
                    PID[i + 1] = tempPID;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }

    public static void quickSort(ArrayList<String[]> list, double[] price, double[] PID, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(list, price, PID, low, high);
            quickSort(list, price, PID, low, pivotIndex - 1);
            quickSort(list, price, PID, pivotIndex + 1, high);
        }
    }

    public static int partition(ArrayList<String[]> list, double[] price, double[] PID, int low, int high) {
        double pivotPrice = price[high];
        double pivotPID = PID[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (price[j] < pivotPrice || (price[j] == pivotPrice && PID[j] < pivotPID)) {
                i++;
                swap(list, i, j);
                swap(price, i, j);
                swap(PID, i, j);
            }
        }

        swap(list, i + 1, high);
        swap(price, i + 1, high);
        swap(PID, i + 1, high);

        return i + 1;
    }

    public static void swap(ArrayList<String[]> list, int i, int j) {
        String[] temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public static void swap(double[] arr, int i, int j) {
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

/* put in readme
Bubble Sort is a simple comparison-based sorting algorithm that repeatedly swaps adjacent elements if they are in the wrong order until the entire list is sorted. It has a time complexity of O(n^2), where n is the number of elements in the list.

On the other hand, Quick Sort is a more efficient sorting algorithm with an average-case time complexity of O(n log n). It uses a divide-and-conquer approach by selecting a pivot element, partitioning the list into two sublists based on the pivot, and recursively sorting the sublists. Quick Sort has better performance for larger lists but can be more complex to implement correctly.
*/
