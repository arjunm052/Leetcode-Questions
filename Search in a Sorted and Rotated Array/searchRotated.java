import java.util.*;

public class searchRotated {
    public static void main(String[] args) {

    }

    // We apply binary search on the array
    public static int search(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        // Final res var
        int res = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            // If element found then return the index
            if (arr[mid] == target) {
                res = mid;
                break;
            }
            // Else just figure out which part of the array is sorted and if the target lies
            // in that range and then update the start and ending index appropriately
            if (arr[start] <= arr[mid]) {
                if (target >= arr[start] && target <= arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            if (arr[mid] <= arr[end]) {
                if (target >= arr[mid] && target <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return res;
    }
}
