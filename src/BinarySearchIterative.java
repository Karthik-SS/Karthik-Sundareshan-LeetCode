public class BinarySearchIterative {

    public static int binarySearchKey(int[] input, int l, int r, int key) {
        while (l <= r) {
            int mid = l + ((r - l) >> 1); //l + ((r - l) >> 1); l + (r - l) / 2;
            if (input[mid] == key) {
                return mid;
            }
            if (key > input[mid]) {
                l = mid + 1;
            }
            if (key < input[mid]) {
                r = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] input = {2, 3, 5, 7, 9, 10, 11, 12, 15};
        int key = 15;
        int keyFound = binarySearchKey(input, 0, input.length - 1, key);
        System.out.println("KeyFound @Position -> " + keyFound);
    }


}
