import java.util.ArrayList;
import java.util.*;

public class CodingPractice {
    class SubsetsBacktrack{
        static int n, k;

        public static void backtrack(int index, int[] nums, List<Integer> cur, List<List<Integer>> output){

            if(cur.size() == k){
                output.add(new ArrayList<>(cur));
                return;
            }

            for(int i = index; i < n; i++){
                cur.add(nums[i]);

                backtrack(i + 1, nums, cur, output);

                cur.remove(cur.size() - 1);
            }
        }

        public static List<List<Integer>> subsets(int[] nums){
            n = nums.length;
            List<List<Integer>> output = new ArrayList<>();
            for(k = 0; k <=n; k++){

                backtrack(0, nums, new ArrayList<>(), output);

            }
            return output;
        }
    }


    class IsSubsequence{
        String source, target;
        int leftBound, rightBound;
        boolean answer = false;

        public boolean isSubsequenceFunc(String s, String t){
            this.source = s;
            this.target = t;

            leftBound = source.length();
            rightBound = target.length();

            return is_recSubsequence(0, 0);

        }

        public boolean is_recSubsequence(int leftIndex, int rightIndex){
            if(leftIndex == leftBound){
                return true;
            }

            if(rightIndex == rightBound){
                return false;
            }

            if(source.charAt(leftIndex) == target.charAt(rightIndex)){
                leftIndex++;
            }
            rightIndex++;

            answer = is_recSubsequence(leftIndex, rightIndex);

            return answer;

        }
    }

}
