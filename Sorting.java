public class Sorting {
    public static void main (String[] args){
        int arr[] = {2,5,1,6,8,4};

        // bubble sort 
/*         for (int i = 0; i<arr.length-1; i++){
            for (int j = 0; j<arr.length-1-i; j++){
                if(arr[j] > arr[j+1]){
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        } */


        // selection sort 
/*         for (int i = 0; i<arr.length-1; i++){
            int smallest = i;
            for(int j = i+1; j<arr.length; j++){
                if(arr[j] < arr[smallest]){
                    smallest = j;
                }
            }
            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;
        } */


        // insertion sort 
/*         for(int i = 1; i<arr.length; i++){
            int current = arr[i];
            int j = i-1;
            while(j>=0 && arr[j]>current){
                // swap
                arr[j+1] = arr[j];
                j--; 
            }
            arr[j+1] = current;
        } */

        printArray(arr);
    }




    public static void printArray(int[] arr){
        for (int i : arr){
            System.out.print(i + " ");
        }
        System.out.println("");
    }
}