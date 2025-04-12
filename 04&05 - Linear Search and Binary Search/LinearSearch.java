public class LinearSearch {

    public static int findFirstNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 5, -1, 7, 9};
        int index1 = findFirstNegative(arr1);
        System.out.println("First negative number index: " + index1);

        int[] arr2 = {3, 5, 1, 7, 9};
        int index2 = findFirstNegative(arr2);
        System.out.println("First negative number index: " + index2);

        int[] arr3 = {-3, 5, 1, 7, 9};
        int index3 = findFirstNegative(arr3);
        System.out.println("First negative number index: " + index3);
    }
}
