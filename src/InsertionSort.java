public class InsertionSort {
    // Java program for implementation of Insertion Sort
        /*Function to sort array using insertion sort*/
        void sort(int[] arr)
        {
            int n = arr.length;
            for (int i = 1; i < n; ++i) {
                int key = arr[i];
                //int j = i - 1;
                int j = i;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            /*  while (j >= 0 && arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j--;
                }
                arr[j + 1] = key;*/

               while (j > 0 && arr[j - 1] > key) {
                    arr[j] = arr[j - 1];
                    j--;
                }
                arr[j] = key;
            }
        }

        /* A utility function to print array of size n*/
        static void printArray(int[] arr)
        {
            int n = arr.length;
            for (int i = 0; i < n; ++i)
                System.out.print(arr[i] + " ");
            System.out.println();
        }

        // Driver method
        public static void main(String[] args)
        {
            //int arr[] = { 12, 11, 13, 5, 6 };
            int arr[] = { 3, 2, 4, 1 };
            InsertionSort ob = new InsertionSort();
            ob.sort(arr);
            printArray(arr);
        }
}
