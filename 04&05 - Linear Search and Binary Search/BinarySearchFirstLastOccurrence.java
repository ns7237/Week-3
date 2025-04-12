public class BinarySearchFirstLastOccurrence {

    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirstOccurrence(nums, target);
        result[1] = findLastOccurrence(nums, target);
        return result;
    }

    private static int findFirstOccurrence(int[] nums, int target) {
        int left = 0, right = nums.length - 1, firstOccurrence = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                firstOccurrence = mid;
                right = mid - 1; // continue to search in the left half
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return firstOccurrence;
    }

    private static int findLastOccurrence(int[] nums, int target) {
        int left = 0, right = nums.length - 1, lastOccurrence = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                lastOccurrence = mid;
                left = mid + 1; // continue to search in the right half
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return lastOccurrence;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] result = searchRange(nums, target);

        System.out.println("First Occurrence: " + result[0]);
        System.out.println("Last Occurrence: " + result[1]);
    }
}
