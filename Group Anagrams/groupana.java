import java.util.*;

public class groupana {
    public static void main(String[] args) {
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println(solve(strs));

    }

    public static List<List<String>> solve(String[] strs) {
        // Map will store the key as a string in sorted order
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        // Will have the final result set
        List<List<String>> res = new ArrayList<>();

        // Traverse over the strings
        for (int i = 0; i < strs.length; i++) {
            // Convert it to char array and sort it
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);

            // If it doesn't exist in the map then store it and add the current string
            if (!map.containsKey(String.valueOf(arr))) {
                map.put(String.valueOf(arr), new ArrayList<>());
                map.get(String.valueOf(arr)).add(strs[i]);
            }
            // otherwise just add the current string
            else {
                map.get(String.valueOf(arr)).add(strs[i]);
            }
        }

        // traverse over the hashmap and add groups of all anagrams to the final result
        for (Map.Entry<String, ArrayList<String>> mp : map.entrySet()) {
            res.add(mp.getValue());
        }

        return res;
    }
}
