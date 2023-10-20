public class bai9 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 6, -5, 4};
        int a = -2, b = 5;
        findMissingIntegers(arr, a, b);
    }

    public static void findMissingIntegers(int[] arr, int a, int b) {
        boolean[] exists = new boolean[b - a + 1]; // tạo một mảng boolean để đánh dấu số có xuất hiện trong mảng hay không
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (num >= a && num <= b) {
                exists[num - a] = true;
            }
        }
        for (int i = a; i <= b; i++) {
            if (!exists[i - a]) {
                System.out.print(i + " ");
            }
        }
    }
}
