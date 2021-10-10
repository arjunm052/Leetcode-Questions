import java.util.*;

//Figure out if we can reach last index from first index

public class jump {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 1, 1, 4 };
        System.out.println(reachable(arr));
    }

    public static boolean reachable(int[] arr) {
        // max represents the farthest index reachable till now
        int max = 0;
        // traverse the array from start and figure out farthest index we can reach to
        // from any point
        for (int i = 0; i < arr.length; i++) {
            if (i > max)
                return false;
            max = Math.max(i + arr[i], max);
        }

        return true;
    }
}
