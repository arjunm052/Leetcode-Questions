import java.util.*;

public class coin {
    public static void main(String[] args) {

    }

    public static int coinChange(int[] deno, int target) {
        // initialize dp array
        int[] dp = new int[target + 1];
        // fill the array with target+1
        Arrays.fill(dp, target + 1);
        // Only 0 coins are needed to make 0 cents
        dp[0] = 0;

        // We fill the dp array in bottom up manner
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < deno.length; j++) {
                // if current coin is <= i then we can either pick the coin or skip it
                if (deno[j] <= i) {
                    // we take the min of value that is already in there and dp[i-coins[j]] after we
                    // have picked the coin
                    dp[i] = Math.min(dp[i], 1 + dp[i - deno[j]]);
                }
            }
        }

        // if at last dp[target]>target then No such combination exists else just return
        // the answer
        return dp[target] > target ? -1 : dp[target];
    }
}