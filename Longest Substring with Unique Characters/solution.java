import java.util.*;

public class solution {
    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(solve(str));
    }

    public static int solve(String str) {
        // Maintain start and end pointer
        int start = 0;
        int end = 0;
        // This var will store the final result
        int res = 0;
        // We also maintain a HashSet that make sures all the characters are unique
        HashSet<Character> set = new HashSet<>();

        // Traverse the whole string
        while (end < str.length()) {
            // If the character at end is not present in set then add it to the set and
            // increase end pointer
            if (!set.contains(str.charAt(end))) {
                set.add(str.charAt(end));
                end++;
                res = Math.max(set.size(), res);
            }
            // else start removing characters frmo the start
            else {
                set.remove(str.charAt(start));
                start++;
            }
        }

        // return the final result
        return res;
    }
}