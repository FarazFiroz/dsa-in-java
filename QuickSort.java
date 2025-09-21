import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args){
        int[] arr = {10, 80, 30, 90, 40, 50, 70};
        System.out.print("Unsorted: " + Arrays.toString(arr));
        System.out.println("");

        quickSort(arr, 0, arr.length-1);
        
        System.out.print("Sorted: " + Arrays.toString(arr));
        System.out.println("");
    }

    public static void quickSort(int[] arr, int low, int high){
        if(low < high){
            int pivIdx = partiton(arr, low, high);

            quickSort(arr, low, pivIdx-1);
            quickSort(arr, pivIdx+1, high);
        }
    }

    public static int partiton(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low-1;

        for(int j=low; j<high; j++){
            if(arr[j]<pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }
}