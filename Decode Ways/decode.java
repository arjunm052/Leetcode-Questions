import java.util.*;

public class decode {
    public static void main(String[] args) {
        String str = "226";
        System.out.println(getDecode(str));
    }

    public static int getDecode(String str) {
        // dp[i] will denote no of ways to decode string of length i
        int[] dp = new int[str.length() + 1];
        // only one way to decode string of length 0
        dp[0] = 1;
        // if the string starts with 0 then we can't decode it else only one way to
        // decode it
        dp[1] = str.charAt(0) == '0' ? 0 : 1;

        // We build up the rest of the dp array with bottom up approach
        for (int i = 2; i <= str.length(); i++) {
            // get the last digit
            int oneDigit = Integer.valueOf(str.substring(i - 1, i));
            // get the last two digits
            int twoDigit = Integer.valueOf(str.substring(i - 2, i));

            // if single digit is not zero then there is a way to decode it
            if (oneDigit >= 1) {
                dp[i] += dp[i - 1];
            }

            // if last two digits >=10 and <=26 then also a way to decode it
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        // return final result
        return dp[str.length()];
    }
}
