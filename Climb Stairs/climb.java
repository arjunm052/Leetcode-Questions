import java.util.*;

public class climb {
    public static void main(String[] args) {
        int n = 39;
        System.out.println(solve(n));
    }

    public static int solve(int n) {
        // dp[i] stores how many ways there are to reach the ith stair
        int[] dp = new int[n + 1];
        // only one way to be at the 0th stair
        dp[0] = 1;
        // only one way to reach the 1st stair 0->1
        dp[1] = 1;
        // Calculate for the rest of the stairs
        // Can only reach the ith stair from i-1 or i-2th stair
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        // dp[n] will have number of ways we can reach nth stair
        return dp[n];
    }
}
