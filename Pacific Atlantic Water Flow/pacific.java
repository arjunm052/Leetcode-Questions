import java.util.*;

public class pacific {
    public static void main(String[] args) {

    }

    // Direction array
    static int[][] dir = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        // Final result list
        List<List<Integer>> res = new ArrayList<>();
        // Check base case for null matrix
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return res;
        }

        // Get row and col
        int row = heights.length;
        int col = heights[0].length;

        // Maintain two visited arrays for both the oceans
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];

        // Apply DFS from the 1st row for pacific and last row for atlantic ocean
        for (int i = 0; i < col; i++) {
            dfs(heights, 0, i, Integer.MIN_VALUE, pacific);
            dfs(heights, row - 1, i, Integer.MIN_VALUE, atlantic);
        }

        // Apply DFS from the 1st col for pacific and last col for atlantic ocean
        for (int i = 0; i < row; i++) {
            dfs(heights, i, 0, Integer.MIN_VALUE, pacific);
            dfs(heights, i, col - 1, Integer.MIN_VALUE, atlantic);
        }

        // Form the resultant array by taking coordinated that are present in both
        // visited arrays
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        // return the final result
        return res;
    }

    public static void dfs(int[][] arr, int i, int j, int prev, boolean[][] ocean) {
        // Base case if coods are out of matrix
        if (i < 0 || i >= arr.length || j < 0 || j >= arr[i].length)
            return;
        // If the current number is smaller than the prev or it has already been visited
        // then we can't go there
        if (arr[i][j] < prev || ocean[i][j])
            return;

        // Mark the node as visited
        ocean[i][j] = true;
        // Apply dfs in all four directions
        for (int[] d : dir) {
            dfs(arr, i + d[0], j + d[1], arr[i][j], ocean);
        }
    }
}
