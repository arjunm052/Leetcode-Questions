import java.util.*;

public class robber {
    public static void main(String[] args) {

    }

    public static int rob(int[] arr) {
        // Base case, No house = no money
        if (arr.length == 0) {
            return 0;
        }

        // if only one house then only one possibility
        if (arr.length == 1) {
            return arr[0];
        }

        // if two houses then we rob the house with more money
        if (arr.length == 2) {
            return Math.max(arr[0], arr[1]);
        }

        // initialize dp array
        int[] dp = new int[arr.length];
        // dp[i] denotes max money we can loot till ith house
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        // we can either loot the current house or keep the other alternating chain
        for (int i = 2; i < arr.length; i++) {
            // rob the current house or the prev house
            dp[i] = Math.max(dp[i - 2] + arr[i], dp[i - 1]);
        }

        // return the final answer
        return dp[arr.length - 1];
    }

}
