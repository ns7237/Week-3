public class BubbleSortStudentMarks {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for(int i=0;i<n-1;i++){
            swapped=false;
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    swapped=true;
                }
            }
            if(!swapped) break;
        }
    }

    public static void printArray(int[] arr) {
        for(int num:arr){
            System.out.print(num+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] marks = {85, 67, 92, 45, 76, 88, 59};
        System.out.println("Original marks:");
        printArray(marks);
        bubbleSort(marks);
        System.out.println("Sorted marks (ascending):");
        printArray(marks);
    }
}
