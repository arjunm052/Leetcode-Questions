import java.util.*;

public class palindrome {
    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(str));
    }

    public static boolean isPalindrome(String str) {
        // Remove all non alphanumeric characters and turn to lowercase
        String res = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // then check for palindrome
        int i = 0, j = res.length() - 1;
        while (i < j) {
            // if char are not equal then return false
            char ich = res.charAt(i++);
            char jch = res.charAt(j--);
            if (ich != jch) {
                return false;
            }
        }

        // else return true
        return true;
    }
}