import java.util.*;

public class bai2 {
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        int comparisons = 0;
        int swaps = 0;
        
        for (int i = 0; i < n-1; i++) {
            int min_idx = i;
            for (int j = i+1; j < n; j++) {
                comparisons++;
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
            swaps++;
            
            // print the state of the sequence after each loop
            System.out.print("After loop " + (i+1) + ": ");
            for (int k = 0; k < n; k++) {
                System.out.print(arr[k] + " ");
            }
            System.out.println();
        }
        
        // print the number of comparisons and swaps made
        System.out.println("Number of comparisons: " + comparisons);
        System.out.println("Number of swaps: " + swaps);
    }

    static void quickSort(int a[], int low, int high){
        int pivotIdx;
        if(low<high){
            pivotIdx = partition(a,low,high);
            quickSort(a,low,pivotIdx-1);
            quickSort(a,pivotIdx+1,high);
        }
    }
    static void swap(int a[], int i, int m){
        int temp = a[m];
        a[m]= a[i];
        a[i] = temp;
    }
    static int partition(int a[], int i, int j){
        int p = a[i];
        int m = i;
        for(int k = i+1; k<=j;++k){
            if(a[k]<p){
                ++m;
                swap(a,k,m);
            }else{

            }
        }
        swap(a,i,m);
        // print the state of the sequence after each loop
        System.out.print("After loop " + (i+1) + ": ");
        for (int k = 0; k < a.length; k++) {
            System.out.print(a[k] + " ");
        }
        System.out.println();
        return m;
    }
    
    public static void main(String[] args) {
        int[] arr = { 5, 3, 8, 6, 2, 7, 1, 4 };
        System.out.println("Original Array: " + Arrays.toString(arr));
        
        selectionSort(arr);
        // quickSort(arr, 0, arr.length-1);
        
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}
