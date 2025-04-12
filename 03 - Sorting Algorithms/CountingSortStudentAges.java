public class CountingSortStudentAges {

    public static void countingSort(int[] arr) {

        int min = 10;
        int max = 18;
        int[] count = new int[max - min + 1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        int[] output = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }
        System.arraycopy(output, 0, arr, 0, arr.length);
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] studentAges = {16, 12, 15, 18, 17, 14, 16, 10, 13, 18};

        System.out.println("Unsorted Student Ages:");
        printArray(studentAges);
        countingSort(studentAges);

        System.out.println("Sorted Student Ages:");
        printArray(studentAges);
    }
}
