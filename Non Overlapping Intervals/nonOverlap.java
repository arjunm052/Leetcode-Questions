import java.util.*;

public class nonOverlap {
    public static void main(String[] args) {

    }

    public int eraseOverlapIntervals(int[][] intervals) {
        // Base case when only one interva;
        if (intervals.length <= 1) {
            return 0;
        }
        // final res
        int res = 0;
        int n = intervals.length;
        // We traverse the intervels through left and right pointer
        int left = 0, right = 1;
        // Sort the intervals in ascending order
        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));

        while (right < n) {
            // If left interval is completely left of right interval means Non Overlapping
            // Case then update both the pointers, No need to remove any intervals
            if (intervals[left][1] <= intervals[right][0]) {
                left = right;
                right += 1;
            }
            // If first interval lies under second interval then just remove the bigger
            // interval - Overlapping case
            else if (intervals[left][1] <= intervals[right][1]) {
                res += 1;
                right += 1;
            }
            // If first interval is bigger than the second interval then just remove the
            // first interval and update the pointers
            else if (intervals[left][1] > intervals[right][1]) {
                res += 1;
                left = right;
                right += 1;
            }
        }

        // return final result
        return res;
    }
}
