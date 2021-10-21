import java.util.*;

//Figure out if we can reach last index from first index

public class jump {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 1, 1, 4 };
        System.out.println(reachable(arr));
    }

    // Return boolean value on whether you can reach the end or not
    public static boolean reachable(int[] arr) {
        // max represents the farthest index reachable till now
        int max = 0;
        // traverse the array from start and figure out farthest index we can reach to
        // from any point
        for (int i = 0; i < arr.length; i++) {
            if (i > max)
                return false;
            max = Math.max(i + arr[i], max);
        }

        return true;
    }

    // Find the minimum number of jumps to reach end
    public static int jump(int[] nums) {

        // Initialize the dp array with Integer MAX_VALUE
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        // Minimum values to reach index 0 is 0
        dp[0] = 0;
        // Start filling up the dp array
        for (int i = 1; i < nums.length; i++) {
            // Traverse from 0 to i-1
            for (int j = 0; j < i; j++) {
                // and check if ith index is reachable from jth index, if yes then update the
                // value
                if (nums[j] + j >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        // return the final answer
        return dp[nums.length - 1];
    }
}
