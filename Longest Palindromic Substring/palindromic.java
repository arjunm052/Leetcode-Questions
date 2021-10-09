import java.util.*;

public class palindromic {
    public static void main(String[] args) {
        String str = "babad";
        System.out.println(solve(str));
    }

    // TIME COMPLEXITY - O(N^2)
    // SPACE COMPLEXITY - O(1)

    public static String solve(String str) {
        // Base case if the string is null or the length is less than 1
        if (str == null || str.length() < 1)
            return "";

        // start and end store the starting and ending index of the longest palindromic
        // substring
        int start = 0;
        int end = 0;

        // We will traverse each character and expand outside from it.
        for (int i = 0; i < str.length(); i++) {
            // Case for odd length palindromic substring like racecar where e matches with
            // itself
            int len1 = expandFromMiddle(str, i, i);
            // Case for even length palindromic substring like abba where left will point to
            // 1 index and right will point to 2 index
            int len2 = expandFromMiddle(str, i, i + 1);
            // Store the max length
            int len = Math.max(len1, len2);

            // If the resultant length is greater than the prev res then just update the
            // start and end index of the resultant substring
            if (len > end - start) {
                // starting index would be current index - half of length of palindromic
                // substring
                start = i - ((len - 1) / 2);
                // ending index would be current index + half of length of palindromic substring
                end = i + (len / 2);
            }
        }

        return str.substring(start, end + 1);
    }

    // We expand from the middle using two pointers left and right towards outside
    // and return the length of longest palindromic substring we can get from there
    public static int expandFromMiddle(String str, int left, int right) {
        // base case
        if (str == null || left > right)
            return 0;

        // start from middle and expand outside
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }

        // return the resultant length -1 because of 0 based indexing
        return right - left - 1;
    }
}
