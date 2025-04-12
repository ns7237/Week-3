public class InsertionSortEmployeeIDs {
    public static void insertionSort(int[] arr) {
        for(int i=1;i<arr.length;i++){
            int key=arr[i];
            int j=i-1;
            while(j>=0 && arr[j]>key){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    }

    public static void printArray(int[] arr) {
        for(int num:arr){
            System.out.print(num+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] employeeIDs = {1042, 1023, 1055, 1011, 1036, 1007};
        System.out.println("Unsorted Employee IDs:");
        printArray(employeeIDs);
        insertionSort(employeeIDs);
        System.out.println("Sorted Employee IDs:");
        printArray(employeeIDs);
    }
}
