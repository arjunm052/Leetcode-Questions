import java.util.*;

public class insertint {
    public static void main(String[] args) {
        int[][] arr = { { 1, 3 }, { 6, 9 } };
        int[] newInterval = { 2, 5 };
        int[][] res = insert(arr, newInterval);
        for (int[] a : res) {
            System.out.println(Arrays.toString(a));
        }
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        // Final resultant list
        List<int[]> res = new ArrayList<>();

        // Traverse the intervals
        for (int[] interval : intervals) {
            // if the current interval lies on the left side of the newInterval then just
            // add it to the resultant list
            if (interval[1] < newInterval[0]) {
                res.add(interval);
            }
            // If the newInterval lies on the left side of current interval then add it to
            // the result list and set currInterval as the new interval
            else if (newInterval[1] < interval[0]) {
                res.add(newInterval);
                newInterval = interval;
            }
            // Else just merge and update the new interval as follows
            else {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);

            }
        }

        // Add the last newInterval to the result
        res.add(newInterval);

        // return the resultant list
        return res.toArray(new int[res.size()][]);
    }
}
