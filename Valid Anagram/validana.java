import java.util.*;

public class validana {
    public static void main(String[] args) {

    }

    public static boolean isAangram(String str1, String str2) {
        // If they have different lengths then they cant be anagrams
        if (str1.length() != str2.length()) {
            return false;
        }

        // Create a hasmap to store frequency of characters
        HashMap<Character, Integer> map = new HashMap<>();
        // Store freq of characters of string 1
        for (int i = 0; i < str1.length(); i++) {
            map.put(str1.charAt(i), map.getOrDefault(str1.charAt(i), 0) + 1);
        }

        // Start decrementing the frequency of characters from map of str2
        for (int i = 0; i < str2.length(); i++) {
            // if map doesnt have that character then string cant be anagrams
            if (!map.containsKey(str2.charAt(i))) {
                return false;
            }
            // if only one frequency then remove the character else decrement it by 1
            if (map.get(str2.charAt(i)) == 1) {
                map.remove(str2.charAt(i));
            } else {
                map.put(str2.charAt(i), map.get(str2.charAt(i)) - 1);
            }
        }

        // if map size has become zero then both strings are anagrams
        if (map.size() == 0) {
            return true;
        }

        // else return false
        return false;
    }
}
