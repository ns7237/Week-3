/*
Problem 1
import java.util.Arrays;
import java.util.Random;

public class RuntimeAnalysis {
    public static void main(String[] args) {
        int[] data = new int[1000000];
        Random rand = new Random();
        for (int i = 0; i < data.length; i++) data[i] = rand.nextInt(1000000);
        int target = data[777777];

        long startLinear = System.nanoTime();
        for (int i : data) {
            if (i == target) break;
        }
        long endLinear = System.nanoTime();
        System.out.println("Linear Search Time: " + (endLinear - startLinear) + " ns");

        Arrays.sort(data);
        long startBinary = System.nanoTime();
        Arrays.binarySearch(data, target);
        long endBinary = System.nanoTime();
        System.out.println("Binary Search Time: " + (endBinary - startBinary) + " ns");
    }
}
*/

/*
Problem 2
import java.util.Arrays;
import java.util.Random;

public class RuntimeAnalysis {
    public static void main(String[] args) {
        int[] arr1 = generateArray(100000);
        int[] arr2 = arr1.clone();
        int[] arr3 = arr1.clone();

        long start = System.nanoTime();
        bubbleSort(arr1);
        System.out.println("Bubble Sort Time: " + (System.nanoTime() - start) + " ns");

        start = System.nanoTime();
        Arrays.sort(arr2); // Default is Dual-Pivot QuickSort
        System.out.println("Java Arrays.sort Time: " + (System.nanoTime() - start) + " ns");

        start = System.nanoTime();
        mergeSort(arr3, 0, arr3.length - 1);
        System.out.println("Merge Sort Time: " + (System.nanoTime() - start) + " ns");
    }

    public static int[] generateArray(int size) {
        int[] arr = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) arr[i] = rand.nextInt();
        return arr;
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = 0; j < arr.length - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j]; arr[j] = arr[j + 1]; arr[j + 1] = temp;
                }
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int[] left = Arrays.copyOfRange(arr, l, m + 1);
        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);
        int i = 0, j = 0, k = l;

        while (i < left.length && j < right.length)
            arr[k++] = left[i] <= right[j] ? left[i++] : right[j++];
        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }
}
*/

/*
Problem 3
public class RuntimeAnalysis {
    public static void main(String[] args) {
        int N = 100000;

        long start = System.nanoTime();
        String s = "";
        for (int i = 0; i < N; i++) s += "a";
        System.out.println("String Time: " + (System.nanoTime() - start) + " ns");

        start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) sb.append("a");
        System.out.println("StringBuilder Time: " + (System.nanoTime() - start) + " ns");

        start = System.nanoTime();
        StringBuffer sf = new StringBuffer();
        for (int i = 0; i < N; i++) sf.append("a");
        System.out.println("StringBuffer Time: " + (System.nanoTime() - start) + " ns");
    }
}
 */

/*
Problem 4
import java.io.*;

public class RuntimeAnalysis {
    public static void main(String[] args) throws Exception {
        File file = new File("largefile.txt"); // Replace with actual 500MB file path

        long start = System.nanoTime();
        FileReader fr = new FileReader(file);
        while (fr.read() != -1) {}
        fr.close();
        System.out.println("FileReader Time: " + (System.nanoTime() - start) + " ns");

        start = System.nanoTime();
        InputStreamReader isr = new InputStreamReader(new FileInputStream(file));
        while (isr.read() != -1) {}
        isr.close();
        System.out.println("InputStreamReader Time: " + (System.nanoTime() - start) + " ns");
    }
}
*/

/*
Problem 5
public class RuntimeAnalysis {
    public static void main(String[] args) {
        int n = 30;

        long start = System.nanoTime();
        int rec = fibonacciRecursive(n);
        System.out.println("Recursive Fibonacci: " + rec + " Time: " + (System.nanoTime() - start) + " ns");

        start = System.nanoTime();
        int itr = fibonacciIterative(n);
        System.out.println("Iterative Fibonacci: " + itr + " Time: " + (System.nanoTime() - start) + " ns");
    }

    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}
*/

/*
Problem 6
import java.util.*;

public class RuntimeAnalysis {
    public static void main(String[] args) {
        int size = 1000000;
        int[] array = new int[size];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            int num = rand.nextInt(size);
            array[i] = num;
            hashSet.add(num);
            treeSet.add(num);
        }

        int target = array[size / 2];

        long start = System.nanoTime();
        for (int i : array) {
            if (i == target) break;
        }
        System.out.println("Array Search Time: " + (System.nanoTime() - start) + " ns");

        start = System.nanoTime();
        hashSet.contains(target);
        System.out.println("HashSet Search Time: " + (System.nanoTime() - start) + " ns");

        start = System.nanoTime();
        treeSet.contains(target);
        System.out.println("TreeSet Search Time: " + (System.nanoTime() - start) + " ns");
    }
}
*/