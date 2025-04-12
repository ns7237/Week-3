import java.util.*;

public class PairWithGivenSum {
    public static boolean hasPairWithSum(int[] arr, int target) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(target - num)) return true;
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {8, 4, 1, 6};
        int target = 10;
        boolean exists = hasPairWithSum(arr, target);
        System.out.println("Pair exists with sum " + target + ": " + exists);
    }
}
