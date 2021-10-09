public class kadane {
    public static void main(String[] args) {

    }

    // Kadanes Algorithm to find max subarray sum
    public int maxSubArray(int[] nums) {
        // Holds the local maxSum
        int currSum = 0;
        // Holds the final maxSum
        int maxSoFar = Integer.MIN_VALUE;

        // Traverse over the array
        for (int i = 0; i < nums.length; i++) {
            // Choose whether to pick the current element in the subarray or start a new
            // subarray
            currSum = Math.max(currSum + nums[i], nums[i]);
            // Update the global result
            maxSoFar = Math.max(maxSoFar, currSum);
        }

        // return the final result
        return maxSoFar;
    }
}
