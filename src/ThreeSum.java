import java.util.*;
public class ThreeSum {
        public static List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < nums.length && nums[i] <= 0; ++i)
                if (
                        i == 0 || nums[i - 1] != nums[i]
                ) {
                    twoSumII(nums, i, res);
                }
            return res;
        }
        static void twoSumII(int[] nums, int i, List<List<Integer>> res) {
            int lo = i + 1, hi = nums.length - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (sum < 0) {
                    ++lo;
                } else if (sum > 0) {
                    --hi;
                } else {
                    res.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));
                    while (lo < hi && nums[lo] == nums[lo - 1]) ++lo;
                }
            }
        }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> list = new ArrayList<>();
        list = threeSum(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println("Triplet List = " +Arrays.toString(list.toArray()));

    }
}
