import java.util.*;

public class longsub {
    public static void main(String[] args) {

    }

    // TC - O(M*N)

    public static int longestSubsequence(String str1, String str2) {
        // Create a dp array..dp[i] denotes the longest common subsequence upto ith
        // index of str1 and jth index of str2
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        // Start filling up the array in bottom up manner
        // If length of any string becomes zero then lcs would be 0
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                // We look at last characters of the string if they are equal then solution
                // would be 1 + dp[i-1][j-1];
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                // Else the solution would be max of dp[i-1][j], dp[i][j-1];
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        // return the final answer
        return dp[str1.length()][str2.length()];
    }
}
