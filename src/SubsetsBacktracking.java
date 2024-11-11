import java.util.ArrayList;
import java.util.List;

public class SubsetsBacktracking {
       // static List<List<Integer>> output = new ArrayList<>();
        static int n, k;
        public static void backtrack(int index, List<Integer> curr, int[] nums, List<List<Integer>> output) {
            // If the combination is done
            if (curr.size() == k) {
                output.add(new ArrayList<>(curr));
                return;
            }
            for (int i = index; i < n; ++i) {
                // Add i into the current combination
                curr.add(nums[i]);

                // Use the   next integers to complete the combination
                backtrack(i + 1, curr, nums, output);

                // Backtrack
                curr.remove(curr.size() - 1);
            }
        }

        public static List<List<Integer>> subsets(int[] nums) {
            n = nums.length;
            List<List<Integer>> output = new ArrayList<>();
            for (k = 0; k <= n; ++k) {
                backtrack(0, new ArrayList<>(), nums, output);
            }
            return output;
        }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> answer;
        answer = subsets(nums);
        for(int i = 0; i < answer.size(); i++){
            System.out.print(answer.get(i) +", ");
        }
    }
}
