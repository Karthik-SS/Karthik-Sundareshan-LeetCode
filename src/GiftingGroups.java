import java.util.*;
public class GiftingGroups {
    public static int countGroups(List<String> related) {
        // Write your code here
        int n = related.size();
        Set<Integer> set = new HashSet<>();
        int output = 0;
        for(int i = 0; i < n; i++){
            String s = related.get(i);
            for(int j = 0; j < s.length(); j++){
                if(i != j && s.charAt(j) == '1'){
                    set.add(i);
                    set.add(j);
                }
            }
        }
        if(!set.isEmpty()){
            output++;
        }
        for(int j = 0; j < n; j++){
            if(!set.contains(j)){
                output++;
            }
        }
        return output;
    }

    public static void main(String[] args) {
        List<String> stringList = List.of(new String[]{"1100", "1110", "0110", "0001"});
        int output = countGroups(stringList);
        System.out.println("Output = " +output);
    }
}
