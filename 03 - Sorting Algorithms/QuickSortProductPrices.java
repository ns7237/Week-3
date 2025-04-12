public class QuickSortProductPrices {
    public static void quickSort(double[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(double[] arr, int low, int high) {
        double pivot = arr[high]; // using last element as pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                double temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        double temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void printArray(double[] arr) {
        for (double price : arr) {
            System.out.print(price + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        double[] productPrices = {899.99, 299.50, 149.00, 499.25, 799.99, 399.75};
        System.out.println("Unsorted Product Prices:");
        printArray(productPrices);
        quickSort(productPrices, 0, productPrices.length - 1);
        System.out.println("Sorted Product Prices (Ascending):");
        printArray(productPrices);
    }
}
