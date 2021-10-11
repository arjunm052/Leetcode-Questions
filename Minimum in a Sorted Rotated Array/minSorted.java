import java.util.*;

public class minSorted {
    public static void main(String[] args) {
        int[] arr = { 3, 4, 5, 1, 2 };
        System.out.println(minElement(arr));
    }

    public static int minElement(int[] arr) {
        // Base case when only one element in the array
        if (arr.length == 1) {
            return arr[0];
        }

        // final res
        int res = 0;

        int start = 0;
        int end = arr.length - 1;

        // apply binary search
        while (start <= end) {
            // calculate mid
            int mid = start + (end - start) / 2;
            // calculate prev and next index
            int prev = (mid - 1 + arr.length) % arr.length;
            int next = (mid + 1) % arr.length;

            // the required element should be smaller than both of its neighbours
            if (arr[mid] <= arr[prev] && arr[mid] <= arr[next]) {
                res = arr[mid];
                break;
            }
            // check on the part that is non sorted
            else if (arr[mid] <= arr[end]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }

        // return final ans
        return res;
    }
}
