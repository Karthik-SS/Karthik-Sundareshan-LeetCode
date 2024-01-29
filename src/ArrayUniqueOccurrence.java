import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ArrayUniqueOccurrence {
    public static boolean uniqueOccurrences(int[] arr) {
        int n = arr.length;
        if (n < 2) {
            return true;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int key : arr) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (int key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }
        System.out.println("++++++++++++++++");
        int nonFactor = 0, factor = 0;

        for (int values : map.values()) {
            if (n % values == 0) {
                factor++;
            } else {
                nonFactor++;
            }
        }

        System.out.println("Factor = " + factor);
        System.out.println("NonFactor = " + nonFactor);
        System.out.println("++++++++++++++++");

        /*if (n % 2 == 0 && factor == nonFactor) {
            return true;
        } else if (n % 2 == 0 && map.size() == factor && map.size() % 2 != 0) {
            return true;
        } else if (n % 2 != 0 && map.size() == factor && nonFactor != 0) {
            return true;
        } else if (n % 2 != 0 && map.size() == nonFactor) {
            return true;
        }*/
        /*System.out.println("++++++XOR+++++++");
        int prev = 0;
        int xor = 0;
        int prevXor = 0;
        for(int value : map.values()){
            xor =  prev ^ value;
            System.out.print(xor + ", ");
            if(xor == 0 || xor == prevXor){
                return false;
            }
            prev = value;
            prevXor = xor;
        }
        System.out.println();
        System.out.println("++++++++++++++++");*/

        int zero = 0;
        int xor = 0;
        int min = Integer.MIN_VALUE;
        map.put(min, min);
        for (int key : map.keySet()) {
            xor = key ^ zero;
            if (map.get(min) == xor) {
                return false;
            } else {
                map.put(min, xor);
            }
        }
        System.out.println("++++++++++++++++");
        return true;
    }

    public static void main(String[] args) {
        // int[] arr = {2, 2, 3, 3, 4, 4, 5, 5};
        // int[] arr = {1, 1, 2, 2, 1, 3};
        // int[] arr = {3, 2, 2, 4, 4, 4};
        // int[] arr = {3, 2, 2, 4, 4, 4, 5};
        // int[] arr = {1, 2, 3, 4, 5};
        // int[] arr = {1, 2};
        // int[] arr = {2, 2, 2, 2, 2};
        // int[] arr = {1, 1, 2, 2, 2};
        //  int[] arr = {2, 2, 3, 3, 4, 4};
        // int[] arr = {26,2,16,16,5,5,26,2,5,20,20,5,2,20,2,2,20,2,16,20,16,17,16,2,16,20,26,16};
        int[] arr = {-130, 21, -154, 159, -44, -126, 165, 68, -126, -126, -126, 128, -94, 165, -30, -44, -39, -94, 21, -130, 68, 68, 128, -130, -39, 181, 68, 68, 68, 139, 139, -39, 21, 21, -39, 68, 128, 131, -126, -154, -30, 165, 21, 159, 181, -39, -126, 131, -94, -44, 131, 128, 21, -44, 128, -94, 183, -94, 131, 139, -44, 128, 21, 181, -44, 131, 128, 131, 21, 68, 181, -44, -126, -130, 131, -190, 131, 181, 165, -94, 165, 165, -30, -154, 68, -39, -44, 165, -39, -126, 68, 68, -130, 68, -94, 181, -44, 131, 21, 183, -44, 21, -39, -130, -39, 131, 21, 165, 165, -126, 165, -44, -94, 68, 68, -94, -126, -126, -30, 181, 165, 68, -44, -39, -94, -126, -126, -30, 68, 181, -44, -94, -126, -44, -94, -30, 131, 165, -190, -130, -94, -94, 181, 128, 181, 181, 181, 139, -130, -94, -130, -130, 139, -130, -90, -154, 181, 165, -30, -154, 165, -190, 159, 165, 139, -126, -44, 131, -44, -190, -126, -130, -94, 128, -154, 68, -130, -130, 68, 21, -44, -30, -126, -126, 131, 159, -190, -126, 181, 139};
        // int[] arr = {2, 2, 3, 3};
        //int[] arr = {1};
        boolean answer = uniqueOccurrences(arr);

        System.out.println("answer = " + answer);
    }
}
