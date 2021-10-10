import java.util.Arrays;

public class uniquePa {
    public static void main(String[] args) {

    }

    static int[][] dp;

    public static int uniquePaths(int m, int n) {
        // Initoalize a new dp array
        dp = new int[m + 1][n + 1];
        // Fill with -1s
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        // return the solution
        return solve(0, 0, m, n);
    }

    public static int solve(int i, int j, int m, int n) {
        // If we have reached the destination index then return 1 means we have found 1
        // way to reach here
        if (i == m - 1 && j == n - 1)
            return 1;
        // If we go out of matrix then just return 0;
        if (i >= m || j >= n)
            return 0;
        // If we have already computed this solution then just return that answer
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        // Else calculate the answer and store it in dp table
        else
            return dp[i][j] = solve(i + 1, j, m, n) + solve(i, j + 1, m, n);
    }
}
