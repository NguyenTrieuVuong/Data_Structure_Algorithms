import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String name = "nguyentrieuvuong";
        String dateOfBirth = "06092002";
        String inputString = name + dateOfBirth;
        char[] inputArray = inputString.toCharArray();

        System.out.println("Input string: " + inputString);

        // Bubble sort
        int n = inputArray.length;
        int swaps = 0;
        for (int i = 0; i < n; ++i) {
            boolean isSorted = true;
            int tempSwaps = 0;
            for (int j = 1; j < n - i; ++j) {
                if (inputArray[j - 1] > inputArray[j]) {
                    char temp = inputArray[j - 1];
                    inputArray[j - 1] = inputArray[j];
                    inputArray[j] = temp;
                    isSorted = false;
                    tempSwaps++;
                }
            }
            swaps += tempSwaps;
            System.out.println("After iteration " + i + ": " + Arrays.toString(inputArray));
            System.out.println("Swaps: " + tempSwaps);
            if (isSorted) {
                break;
            }
        }

        String sortedString = new String(inputArray);
        System.out.println("Sorted string: " + sortedString);
        System.out.println("Total swaps: " + swaps);
    }
}
