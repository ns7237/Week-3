import java.util.Arrays;

public class SearchExample {

    public static int findFirstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (Math.abs(nums[i]) - 1 < n && nums[Math.abs(nums[i]) - 1] > 0) {
                nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return n + 1;
    }

    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        int target = 4;

        int firstMissingPositive = findFirstMissingPositive(nums);
        System.out.println("First missing positive integer: " + firstMissingPositive);

        Arrays.sort(nums);
        int targetIndex = binarySearch(nums, target);
        System.out.println("Index of target " + target + ": " + targetIndex);
    }
}
