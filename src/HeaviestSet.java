import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.*;

public class HeaviestSet {
    public static List<Integer> minimalHeaviestSetA(List<Integer> arr) {
        // Write your code here
        //2, 3, 5, 6, 7 = 23
        //1, 2, 3, 4, 5, 6 = 21
        List<Integer> output = new ArrayList<>();
        int n = arr.size();
        int sum = 0;
        int dec = 0;
        Collections.sort(arr);
        for(int i = 0; i < n; i++){
            sum += arr.get(i);
        }
        for(int j = n - 1; j >= 0; j--){
            output.add(arr.get(j));
            dec += arr.get(j);
            sum -= (sum - arr.get(j));
            if(dec > sum){
                break;
            }
        }
        Collections.reverse(output);
        return output;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        /*list.add(6);
        list.add(4);
        list.add(1);
        list.add(5);
        list.add(2);
        list.add(3);*/
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(6);
        list.add(7);
        List<Integer> output = new ArrayList<>();
        output = minimalHeaviestSetA(list);
        for(int i = 0; i < output.size(); i++){
            System.out.print(output.get(i) +", ");
        }
    }
}
