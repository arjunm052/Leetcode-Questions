public class robberII {
    public static void main(String[] args) {

    }
    // HOUSE ROBBER II - CANNOT LOOT ADJACENT HOUSES AND THE HOUSES ARE ARRANGED IN
    // CICULAR MANNER

    // Main Funciton
    public int rob(int[] nums) {
        // Base cases
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        // Return max of excluding either first or last house
        return Math.max(helper(nums, 0, nums.length - 1), helper(nums, 1, nums.length));
    }

    public static int helper(int[] arr, int start, int end) {
        // Max will hold the max amount of money that can bne looted till current house
        // prevOne till last house
        // prevTwo till second last house
        int prevOne = 0, prevTwo = 0, max = 0;
        for (int i = start; i < end; i++) {
            max = Math.max(prevTwo + arr[i], prevOne);
            prevTwo = prevOne;
            prevOne = max;
        }

        return max;
    }
}
