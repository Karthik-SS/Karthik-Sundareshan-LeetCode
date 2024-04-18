public class BinarySearchRecursion {
    private static boolean binarySearchRecursion(int[] input, int l, int r, int key) {
        if(l <= r){
            int mid = l + (r - l)/2;

            if(input[mid] == key){
                return true;
            }
            if(key > input[mid]){
                return binarySearchRecursion(input, mid + 1, r, key);
            }else{
                return binarySearchRecursion(input, l, mid - 1, key);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] input = {2, 3, 5, 7, 9, 10, 11, 12, 15};
        int key = 11;
        boolean keyFound = binarySearchRecursion(input, 0, input.length - 1, key);
        System.out.println("keyFound = " + keyFound);
    }

}
