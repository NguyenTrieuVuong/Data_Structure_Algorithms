import java.util.Arrays;
public class bai12 {
    public static int findKthSmallest(int[] arr, int k) {
        int[] nums = new int[1000000];
        int count = 0;
        for (int i = 1; i <= nums.length; i++) {
            if (count < arr.length && i == arr[count]) {
                count++;
            } else {
                nums[i - 1 - count] = i;
            }
        }
        Arrays.sort(nums);
        if (k > nums.length) {
            return -1;
        } else {
            return nums[k - 1];
        }
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 5 };
        int k = 4;
        int result = findKthSmallest(arr, k);
        System.out.println(result);

    }
}
