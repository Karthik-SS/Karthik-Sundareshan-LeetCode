import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ArrayUniqueOccurrence2 {
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
        int prevVal = 0, curVal = 0;
        //boolean sameVal = false;
        for (int values : map.values()) {
          int index = values - 1;
          int minVal = Integer.MIN_VALUE;
          if(arr[index] == minVal){
              return false;
          }
          arr[index] = minVal;
        }
        return true;
    }

    public static void main(String[] args) {
        // int[] arr = {2, 2, 3, 3, 4, 4, 5, 5};
        int[] arr = {1, 1, 2, 2, 1, 3};
        // int[] arr = {3, 2, 2, 4, 4, 4};
        // int[] arr = {3, 2, 2, 4, 4, 4, 5};
        // int[] arr = {1, 2, 3, 4, 5};
        // int[] arr = {1, 2};
        // int[] arr = {2, 2, 2, 2, 2};
        // int[] arr = {1, 1, 2, 2, 2};
         //int[] arr = {2, 2, 3, 3, 4, 4};
        // int[] arr = {2, 2, 3, 3};
        // int[] arr = {1};
        boolean answer = uniqueOccurrences(arr);
        System.out.println("++++++++++++++++");
        System.out.println("answer = " + answer);
    }
}
