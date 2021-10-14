import java.util.*;

public class longrep {
    public static void main(String[] args) {

    }

    // TC - O(N)
    public static int longestRepeating(String str, int k) {
        // Length of string
        int n = str.length();
        // Count array to store frequency of characters
        int[] count = new int[26];
        // MaxCount denotes the highest frequency in the substring found yet
        int maxCount = 0;
        // Max Length will hold the final answer
        int maxLength = 0;
        // We initialize start and end from 0
        int start = 0;
        for (int end = 0; end < n; end++) {
            // First step is to update the maxCount
            maxCount = Math.max(maxCount, ++count[str.charAt(end) - 'A']);
            // If the string is invalid then update the start pointer to make it valid
            while (end - start + 1 - maxCount > k) {
                count[str.charAt(start) - 'A']--;
                start++;
            }

            // update the max length afte the string is valid
            maxLength = Math.max(maxLength, end - start + 1);
        }

        // return the final answer
        return maxLength;
    }

}
