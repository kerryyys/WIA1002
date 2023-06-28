package sorting;

import java.util.*;

public class L8Q3 {

    public static void main(String[] args) {
        System.out.println("Perfomance Comparison of Sorting Algorithms");
        System.out.println("Running on 100 sets of 100000 random numbers: ");

        int[][] randomSets = generateRandomSets(1000, 100000);

        long selectionSortTime = 0;
        long bubbleSortTime = 0;
        long insertionSortTime = 0;
        long mergeSortTime = 0;
        long quickSortTime = 0;

        for (int i = 0; i < randomSets.length; i++) {
            int[] set = randomSets[i];

            // Measure the time for Selection Sort
            long startTime = System.currentTimeMillis();
            SelectionSort(set);
            long endTime = System.currentTimeMillis();
            selectionSortTime += endTime - startTime;

            // Measure the time for Bubble Sort
            long startTimeBubble = System.currentTimeMillis();
            BubbleSort(set);
            long endTimeBubble = System.currentTimeMillis();
            bubbleSortTime += endTimeBubble - startTimeBubble;

            // Measure the time for Insertion Sort
            long INSERTstartTime = System.currentTimeMillis();
            InsertionSort(set);
            long INSERTendTime = System.currentTimeMillis();
            insertionSortTime += INSERTendTime - INSERTstartTime;

            // Measure the time for Merge Sort
            long MERGEstartTime = System.currentTimeMillis();
            MergeSort(set);
            long MERGEendTime = System.currentTimeMillis();
            mergeSortTime += MERGEendTime - MERGEstartTime;

            // Measure the time for Quick Sort
            long QUICKstartTime = System.currentTimeMillis();
            QuickSort(set);
            long QUICKendTime = System.currentTimeMillis();
            quickSortTime += QUICKendTime - QUICKstartTime;
        }

        // Compare the times and identify the fastest sorting algorithm
        long[] times = { selectionSortTime, bubbleSortTime, insertionSortTime, mergeSortTime, quickSortTime };
        String[] algorithms = { "Selection Sort", "Bubble Sort", "Insertion Sort", "Merge Sort", "Quick Sort" };

        long fastestTime = Long.MAX_VALUE;
        String fastestAlgorithm = "";

        for (int i = 0; i < times.length; i++) {
            if (times[i] < fastestTime) {
                fastestTime = times[i];
                fastestAlgorithm = algorithms[i];
            }
        }

        System.out.println("Fastest Sorting Algorithm: " + fastestAlgorithm);
        System.out.println("Time taken: " + fastestTime + " milliseconds");
    }

    public static void SelectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int currentIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    currentIndex = j;
                }
            }
            if (min != arr[i]) {
                arr[currentIndex] = arr[i];
                arr[i] = min;
            }
        }
    }

    public static void BubbleSort(int[] arr) {
        boolean needNextPass = true;
        for (int i = 0; i < arr.length - 1; i++) {
            needNextPass = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    needNextPass = true;
                }
            }
            if (!needNextPass) {
                break;
            }
        }
    }

    public static void InsertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int k;
            for (k = i - 1; k >= 0 && arr[k] > current; k--) {
                arr[k + 1] = arr[k];
            }
            arr[k + 1] = current;
        }
    }

    public static void MergeSort(int[] arr) {
        if (arr.length > 1) {
            int leftlength = arr.length / 2;
            int[] left = new int[leftlength];
            System.arraycopy(arr, 0, left, 0, leftlength);
            MergeSort(left);

            int rightLength = arr.length - leftlength;
            int[] right = new int[rightLength];
            System.arraycopy(arr, leftlength, right, 0, rightLength);
            MergeSort(right);

            /*
             * can use
             * int mid = arr.length / 2;
             * int[] left = Arrays.copyOfRange(arr, 0, mid);
             * int[] right = Arrays.copyOfRange(arr, mid, arr.length);
             */

            merge(left, right, arr);
        }
    }

    public static void merge(int[] left, int[] right, int[] arr) {
        int leftIndex = 0;
        int rightIndex = 0;
        int arrIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] >= right[rightIndex]) {
                arr[arrIndex++] = right[rightIndex++];
            } else {
                arr[arrIndex++] = left[leftIndex++];
            }
        }
        while (leftIndex < left.length) {
            arr[arrIndex++] = left[leftIndex++];
        }
        while (rightIndex < right.length) {
            arr[arrIndex++] = right[rightIndex++];
        }
    }

public static void QuickSort(int[] arr) {
    QuickSort(arr, 0, arr.length - 1);
}

private static void QuickSort(int[] arr, int low, int high) {
    while (low < high) {
        int partitionIndex = partition(arr, low, high);
        QuickSort(arr, low, partitionIndex - 1);
        low = partitionIndex + 1;
    }
}

private static int partition(int[] arr, int low, int high) {
    int pivot = arr[low];
    int i = low + 1;
    int j = high;

    while (i <= j) {
        if (arr[i] > pivot && arr[j] < pivot) {
            swap(arr, i, j);
            i++;
            j--;
        } else {
            if (arr[i] <= pivot) {
                i++;
            }
            if (arr[j] >= pivot) {
                j--;
            }
        }
    }

    swap(arr, low, j);
    return j;
}

private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

    // Generate random sets of numbers
    public static int[][] generateRandomSets(int numSets, int setSize) {
        int[][] randomSets = new int[numSets][setSize];
        Random random = new Random();

        for (int i = 0; i < numSets; i++) {
            for (int j = 0; j < setSize; j++) {
                randomSets[i][j] = random.nextInt();
            }
        }

        return randomSets;
    }
}