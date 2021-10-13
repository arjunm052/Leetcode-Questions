public class countPal {
    public static void main(String[] args) {

    }

    public static int countPalindrome(String str) {
        // final result
        int res = 0;

        // dp[i][j] stores whether str.substring(i,j) is a palindrome or not
        boolean dp[][] = new boolean[str.length()][str.length()];

        // We fill the dp array diagonally
        // gap is basically the difference between ending index and starting index of
        // substring

        for (int gap = 0; gap < str.length(); gap++) {
            // For gap 0 we start from 0th column, 1st col for gap 1 and so on
            // We only fill till the last column
            for (int i = 0, j = gap; j < dp.length; i++, j++) {
                // For string of length 1
                if (gap == 0) {
                    dp[i][j] = true;
                }
                // For string of length 2
                else if (gap == 1) {
                    // Just check if the first and last character are equal to each other
                    if (str.charAt(i) == str.charAt(j)) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                }
                // A substring str from i to j is palindromic if charAt(i)==charAt(j) and
                // substring from i+1 to j-1 is also palindromic
                else {
                    // if first and last character are equal and substring from i+1 to j-1 is also
                    // palindrome then set dp[i][j] to true
                    if (str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1] == true) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                }
                // If we found a palindrome then just increment the result
                if (dp[i][j] == true) {
                    res++;
                }
            }
        }
        // return the final result
        return res;
    }
}
