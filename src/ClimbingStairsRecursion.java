import java.util.*;

public class ClimbingStairsRecursion {
    public static int climbStairs(int n) {
        return climb_Stairs(0, n);
    }

    public static int climb_Stairs(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
    }

    public static int climb_Stairs(int i, int n, int[] memo) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        // Check if result is already calculated
        if (memo[i] != -1) {
            return memo[i];
        }
        // Calculate and store in memo
        memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);
        return memo[i];
    }

    /*public static int climbStairsMemo(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1); // Initialize memo with -1 to indicate uncalculated steps
        return climb_Stairs(0, n, memo);
    }*/

    public static int climbStairsDP(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        int answer = climbStairs(n);
        System.out.println("Exponential Recursion Answer = " +answer);

        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1); // Initialize memo with -1 to indicate uncalculated steps
        int output =  climb_Stairs(0, n, memo);

        System.out.println("Memoization Output = " +output);

        int result = climbStairsDP(n);
        System.out.println("DP Result = " +result);
    }
}
