import java.util.*;

public class missing {
    public static void main(String[] args) {

    }

    // TC - O(N)
    public int missingNumber(int[] arr) {
        int res = arr.length;
        for (int i = 0; i < arr.length; i++) {
            res = res ^ i ^ arr[i];
        }

        return res;
    }

    // O(NLOGN) TC
    public int naiveSolution(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i) {
                return i;
            }
        }

        return arr.length;
    }
}
