import java.util.*;

public class loncon {
    public static void main(String[] args) {

    }

    public static int longestConsecutive(int[] arr) {
        // Base case
        if (arr.length == 0) {
            return 0;
        }

        // Push all the element of the array in the hash set
        Set<Integer> set = new HashSet<>();
        for (int x : arr) {
            set.add(x);
        }

        // initialize result to 1
        int res = 1;

        // now traverse the hashset
        for (int x : set) {
            // we only look for a sequence if the current element is the smallest one in
            // sequence
            if (!set.contains(x - 1)) {
                int curr = 1;
                // while more number exists in the sequence in crease curr
                while (set.contains(x + curr)) {
                    curr++;
                }
                // update the result
                res = Math.max(res, curr);
            }
        }

        return res;
    }
}
