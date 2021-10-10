
import java.util.*;

public class merge {
    public static void main(String[] args) {
        int[][] arr = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        int[][] res = mergeIntervals(arr);
        for (int[] a : res) {
            System.out.println(Arrays.toString(a));
        }
    }

    public static int[][] mergeIntervals(int[][] intervals) {
        // If only one interval exists then just return it as it is
        if (intervals.length <= 1) {
            return intervals;
        }

        // First sort the intervals according to their starting point
        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
        List<int[]> res = new ArrayList<>();

        // Current Interval will be the last interval in the output array
        int[] currentInterval = intervals[0];
        // Add the first interval
        res.add(currentInterval);

        // Traverse the rest of the array
        for (int[] interval : intervals) {
            // Get the attributes of currentInterval and nextInterval
            int currBegin = currentInterval[0];
            int currEnd = currentInterval[1];
            int nextBegin = interval[0];
            int nextEnd = interval[1];

            // Check if they overlap. Merge if they do
            if (currEnd >= nextBegin) {
                currentInterval[1] = Math.max(currEnd, nextEnd);
            }
            // Else add the interval to the output and make it current
            else {
                currentInterval = interval;
                res.add(currentInterval);
            }
        }

        // return the final result
        return res.toArray(new int[res.size()][]);
    }

}
