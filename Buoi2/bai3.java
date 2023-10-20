import java.util.*;

public class bai3 {
    public static void main(String[] args) {
        int[] arr = { 5, 3, 8, 6, 2, 7, 1, 4 };
        System.out.println("Original Array: " + Arrays.toString(arr));
        insertionSort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        int comparisons = 0;
        int swaps = 0;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
                swaps++;
                comparisons++;
            }
            arr[j + 1] = key;
            comparisons++;

            System.out.println("After iteration " + i + ": " + Arrays.toString(arr));
        }
        System.out.println("Number of comparisons: " + comparisons);
        System.out.println("Number of swaps: " + swaps);
    }

}
