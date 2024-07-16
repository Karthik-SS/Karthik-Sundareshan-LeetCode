import java.util.*;
import java.util.stream.*;
public class MaximumInSlidingWindow {
        // function to clean up the window
        public static Deque<Integer> cleanUp(int i, Deque<Integer> currentWindow, int[] nums) {
            while (!currentWindow.isEmpty() && nums[i] >= nums[currentWindow.getLast()]) {
                currentWindow.removeLast();
            }
            return currentWindow;
        }
        // function to find the maximum in all possible windows
        public static int[] findMaxSlidingWindow(int[] nums, int w) {
            if (nums.length == 1) {
                return nums;
            }
            int [] output = new int[nums.length - w + 1];
            Deque<Integer> currentWindow = new ArrayDeque<>();
            for (int i = 0; i < w; i++) {
                currentWindow = MaximumInSlidingWindow.cleanUp(i, currentWindow, nums);
                currentWindow.add(i);
            }
            output[0] = nums[currentWindow.getFirst()];
            for (int i = w; i < nums.length; i++) {
                cleanUp(i, currentWindow, nums);
                if (!currentWindow.isEmpty() && currentWindow.getFirst() <= (i - w)) {
                    currentWindow.removeFirst();
                }
                currentWindow.add(i);
                output[i - w + 1] = nums[currentWindow.getFirst()];
            }
            return output;
        }
        // driver code
        public static void main(String args[]) {
            /*int [][] numLists = {
                    {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                    {10, 9, 8, 7, 6, 5, 4, 3, 2, 1},
                    {10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
                    {1, 5, 8, 10, 10, 10, 12, 14, 15, 19, 19, 19, 17, 14, 13, 12, 12, 12, 14, 18, 22, 26, 26, 26, 28, 29, 30},
                    {10, 6, 9, -3, 23, -1, 34, 56, 67, -1, -4, -8, -2, 9, 10, 34, 67},
                    {4, 5, 6, 1, 2, 3},
                    {9, 5, 3, 1, 6, 3},
                    {2, 4, 6, 8, 10, 12, 14, 16},
                    {-1, -1, -2, -4, -6, -7},
                    {4, 4, 4, 4, 4, 4}
            };*/

            int[] nums = {10,6,9,-3,23,-1,34,56,67,-1,-4,-8,-2,9,10,34,67};
            // Expected = [10, 9, 23, 23, 34, 56, 67, 67, 67, -1, -2, 9, 10, 34, 67]
            //             10, 9, 23, 23, 34, 56, 67, 67, 67, -1, -2, 9, 10, 34, 67,
            //             10, 9, 23, 23, 34, 56, 67, 67, 67, -1, -2, 9, 10, 34, 67, 0,
            int w = 3;
            int[] output = MaximumInSlidingWindow.findMaxSlidingWindow(nums, w);
            for(int i = 0; i < output.length; i++){
                System.out.print(output[i]+", ");
            }

        }
}
