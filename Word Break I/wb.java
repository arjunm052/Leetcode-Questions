import java.util.*;

public class wb {
    public static void main(String[] args) {
        String str = "leetcode";
        String[] dict = { "leet", "code" };
        System.out.println(solve(str, dict));
    }

    public static boolean solve(String str, String[] dict) {
        // DP[i] denotes whether we can segment the substring i to n-1 into words that
        // we have in dictionary
        boolean dp[] = new boolean[str.length() + 1];
        dp[str.length()] = true;

        // Push all the words in set for faster access
        HashSet<String> set = new HashSet<>();
        for (String s : dict) {
            set.add(s);
        }

        // Start traversing from the end of string
        for (int i = str.length() - 1; i >= 0; i--) {
            // All the substring generated will se assigned to word
            String word = "";
            // Generate all substring from ith index to n-1
            for (int j = i; j < str.length(); j++) {
                word += String.valueOf(str.charAt(j));
                // Check if that word already exists in the set
                if (set.contains(word)) {
                    // if we can segment words from i to j and j+1 to n-1 then set dp[i] = true
                    if (dp[j + 1]) {
                        dp[i] = true;
                    }
                }
            }
        }

        // dp[0] will have the final answer if we can partition from 0 to n-1 into words
        // that are in dictionary
        return dp[0];

    }

}
