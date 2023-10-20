import java.util.Arrays;
import java.util.Random;

public class SortingAlgorithms {

    public static void main(String[] args) {
        // Create an array of 100,000 random integers.
        int[] array = new int[100000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt();
        }

        // Time the execution of the four sorting algorithms.
        long selectionSortTime = timeSelectionSort(array);
        long heapSortTime = timeHeapSort(array);
        long quickSortTime = timeQuickSort(array);
        long mergeSortTime = timeMergeSort(array);

        // Print the execution times of the four sorting algorithms.
        System.out.println("SelectionSort: " + selectionSortTime);
        System.out.println("HeapSort: " + heapSortTime);
        System.out.println("QuickSort: " + quickSortTime);
        System.out.println("MergeSort: " + mergeSortTime);
    }

    private static long timeSelectionSort(int[] array) {
        long start = System.nanoTime();
        SelectionSort.sort(array);
        long end = System.nanoTime();
        return end - start;
    }

    private static long timeHeapSort(int[] array) {
        long start = System.nanoTime();
        HeapSort.heapSort(array);
        long end = System.nanoTime();
        return end - start;
    }

    private static long timeQuickSort(int[] array) {
        long start = System.nanoTime();
        QuickSort.sort(array);
        long end = System.nanoTime();
        return end - start;
    }

    private static long timeMergeSort(int[] array) {
        long start = System.nanoTime();
        MergeSort.sort(array);
        long end = System.nanoTime();
        return end - start;
    }

    public static void heapSort(int[] array) {
        // Create a MinHeapPriorityQueue from the array.
        MinHeapPriorityQueue<Integer> heap = new MinHeapPriorityQueue<>();
        for (int i : array) {
            heap.add(i);
        }
    
        // Heapify the heap.
        for (int i = heap.size() / 2; i >= 0; i--) {
            heap.downHeap(i);
        }
    
        // Sort the array by repeatedly removing the minimum element from the heap and adding it to the end of the array.
        for (int i = array.length - 1; i >= 0; i--) {
            array[i] = heap.remove();
        }
    }
    
}
