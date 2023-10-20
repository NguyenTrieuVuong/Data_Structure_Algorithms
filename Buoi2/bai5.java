public class bai5<T extends Comparable<T>> {
    
    private int comparisons = 0;
    private int swaps = 0;
    
    public void sort(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            T key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j--;
                swaps++;
                comparisons++;
            }
            arr[j + 1] = key;
            comparisons++;
            System.out.print("After loop " + (i+1) + ": ");
            for (int k = 0; k < arr.length; k++) {
                System.out.print(arr[k] + " ");
            }
            System.out.println();
        }
        System.out.println("Number of comparisons: " + comparisons);
        System.out.println("Number of swaps: " + swaps);
    }
    
    
    public static void main(String[] args) {
        Integer[] arr = {5, 2, 4, 6, 1, 3};
        bai5<Integer> sorter = new bai5<>();
        sorter.sort(arr);
    }
}
