public class BubbleSort {
    public static int[] bubbleSortFunction(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < n - i - 1; j++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        //int[] arr = {3,2,6,1,5,4};
        int[] arr = {3, 2, 4, 1};
        System.out.println("Before Sorting");
        System.out.println("/****************/");
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+", ");
        }
        System.out.println();
        int[] answer = bubbleSortFunction(arr);
        System.out.println("After Sorting");
        System.out.println("/****************/");
        for (int i = 0; i < answer.length; i++){
            System.out.print(arr[i]+", ");
        }

    }
}
