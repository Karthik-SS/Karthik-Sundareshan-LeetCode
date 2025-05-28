public class MergeSort {
    public static void mergeSort(int[] arr, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] larray = new int[mid];
        int[] rarray = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            larray[i] = arr[i];
        }
        for (int j = mid; j < n; j++) {
            rarray[j - mid] = arr[j];
        }
        mergeSort(larray, mid);
        mergeSort(rarray, n - mid);
        merge(arr, larray, rarray, mid, n - mid);
    }

    public static void merge(int[] arr, int[] larray, int[] rarray, int leftBound, int rightBound) {
        int i = 0, j = 0, k = 0;
        while (i < leftBound && j < rightBound) {
            if (larray[i] <= rarray[j]) {
                arr[k++] = larray[i++];
            } else {
                arr[k++] = rarray[j++];
            }
        }
        while (i < leftBound) {
            arr[k++] = larray[i++];
        }
        while (j < rightBound) {
            arr[k++] = rarray[j++];
        }
    }
    public static void main(String[] args) {
        //int[] actual = { 5, 1, 6, 2, 3, 4 };
        int[] actual = {3, 2, 4, 1};
        mergeSort(actual, actual.length);
        for (int i = 0; i < actual.length; i++) {
            if (i + 1 == actual.length) {
                System.out.print(actual[i]);
            } else {
                System.out.print(actual[i] + ",");
            }
        }
    }
}
