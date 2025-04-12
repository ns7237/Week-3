public class SelectionSortExamScores {
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first unsorted element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void printArray(int[] arr) {
        for (int score : arr) {
            System.out.print(score + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] examScores = {88, 76, 93, 85, 67, 91, 78};
        System.out.println("Unsorted Exam Scores:");
        printArray(examScores);
        selectionSort(examScores);
        System.out.println("Sorted Exam Scores (Ascending):");
        printArray(examScores);
    }
}
