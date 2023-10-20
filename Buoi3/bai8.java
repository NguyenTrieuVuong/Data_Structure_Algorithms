import java.util.Arrays;

public class bai8 {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 6, -5, 4 };
        int res = findSmallestPositiveInt(arr);
        System.out.println("Smallest positive integer not in the array: " + res);
    }

    public static int findSmallestPositiveInt(int[] arr) {
        Arrays.sort(arr);
        int smallestInt = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= 0) {

                continue;
            } else if (arr[i] == smallestInt) {

                smallestInt++;
            } else if (arr[i] > smallestInt) {

                return smallestInt;
            }
        }

        return smallestInt;
    }
}
