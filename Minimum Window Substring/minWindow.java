import java.util.*;

public class minWindow {
    public static void main(String[] args) {
        String str = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(solve(str, t));
    }

    public static String solve(String str, String t) {
        // This will have the final result
        String ans = "";

        // Create a hashmap to store the frequency of characters in T String and fill it
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        // We will use the acquire and release strategy to solve this problem

        // When we acquire a character that is needed then we increase the match count
        int mct = 0;
        // This is the desired match count that we need
        int dmct = t.length();

        int i = -1;
        int j = -1;
        // This will store the frequency of characters of the substring that we
        // currently have
        HashMap<Character, Integer> map1 = new HashMap<>();

        while (true) {
            boolean f1 = false;
            boolean f2 = false;
            // First we acquire the characters until we find a string that can be our answer
            while (i < str.length() - 1 && mct < dmct) {
                // Acquire the character and update its frequency in map1
                i++;
                char c = str.charAt(i);
                map1.put(c, map1.getOrDefault(c, 0) + 1);

                // If we have acquired the desired character then only increase the mct
                if (map1.getOrDefault(c, 0) <= map2.getOrDefault(c, 0)) {
                    mct++;
                }
                f1 = true;
            }

            // Time to collect answers and release
            while (j < i && mct == dmct) {
                // Get the potential answer
                String pans = str.substring(j + 1, i + 1);
                // If this is the first answer or it's length is smallest than the current
                // answer then update our answer
                if (ans.length() == 0 || pans.length() < ans.length()) {
                    ans = pans;
                }

                // Release the Character
                j++;
                char ch = str.charAt(j);

                // If character has frequency 1 then just remove it
                if (map1.get(ch) == 1) {
                    map1.remove(ch);
                } else {
                    map1.put(ch, map1.get(ch) - 1);
                }

                // If we have taken out a critical character that was needed then decrease the
                // match count
                if (map1.getOrDefault(ch, 0) < map2.getOrDefault(ch, 0)) {
                    mct--;
                }
                f1 = true;
            }

            if (f1 == false && f2 == false) {
                break;
            }
        }

        // Return the final answer string
        return ans;
    }
}
