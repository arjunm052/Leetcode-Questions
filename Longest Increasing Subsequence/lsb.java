import java.util.*;

public class lsb {
    public static void main(String[] args) {

    }

    public static int subsequence(int[] arr) {
        // Initialize dp array
        int[] dp = new int[arr.length];
        // fill with default value 1
        Arrays.fill(dp, 1);

        // For every element find the longest increasing subsequence ending at that
        // point
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                // if the current element is greater than the one's before it then update dp[i]
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }

        // find the longest subsequence ending at any point in dp array
        int longest = 0;
        for (int i = 0; i < dp.length; i++) {
            longest = Math.max(longest, dp[i]);
        }

        // return the result
        return longest;
    }
}
