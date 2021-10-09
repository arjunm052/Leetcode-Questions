import java.util.*;

public class container {
    public static void main(String[] args) {
        int[] arr = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println(solve(arr));
    }

    public static int solve(int[] arr) {
        // Will store the final result
        int res = 0;

        // Two pointers that marks start from beginning and ending of array
        int left = 0;
        int right = arr.length - 1;

        // Move the pointer towards each other and calculate the area using the shorter
        // height and store the result and then move the pointer
        while (left < right) {
            if (arr[left] < arr[right]) {
                res = Math.max(res, arr[left] * (right - left));
                left++;
            } else {
                res = Math.max(res, arr[right] * (right - left));
                right--;
            }
        }

        // return the final result
        return res;
    }
}
