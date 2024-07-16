public class QuickSort {
    public static void main(String[] args) {
        //int[] actual = { 5, 1, 6, 2, 3, 4 };
        int[] arr = {7, 2, 1, 6, 8, 5, 3, 4};
        int n = arr.length;
        quicksort(arr, 0, n - 1);
        for (int i = 0; i < arr.length; i++) {
            if (i + 1 == arr.length) {
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + ",");
            }
        }
    }
    private static void quicksort(int[] arr, int start, int end) {
        if(start < end){
            int partitionIndex = partition(arr, start, end);
            quicksort(arr, start, partitionIndex - 1);
            quicksort(arr, partitionIndex + 1, end);
        }
    }
    private static int partition(int[] arr, int start, int end) {
       int pivot = arr[end];
       int parIndex = start;
       for(int i = start; i < end; i++){
           if(arr[i] <= pivot){
               swap(arr, i, parIndex);
               parIndex++;
           }
       }
       swap(arr, parIndex, end);
       return parIndex;
    }
    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
