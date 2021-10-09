import java.util.*;

public class solution {
    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(solve(str));
    }

    public static int solve(String str) {
        int start = 0;
        int end = 0;
        int res = 0;
        HashSet<Character> set = new HashSet<>();

        while (end < str.length()) {
            if (!set.contains(str.charAt(end))) {
                set.add(str.charAt(end));
                end++;
                res = Math.max(set.size(), res);
            } else {
                set.remove(str.charAt(start));
                start++;
            }
        }

        return res;
    }
}