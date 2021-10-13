import java.util.*;

public class dup {
    public static void main(String[] args) {

    }

    public static boolean containsDuplicate(int[] arr) {
        // Use a hash set to store elements
        HashSet<Integer> set = new HashSet<>();
        // Traverse through the array
        for (int x : arr) {
            // If the element already exists then duplicate found return true
            if (set.contains(x)) {
                return true;
            }
            // else add the element to the set
            set.add(x);
        }

        // return false if no duplicate element found
        return false;
    }
}
