public class stockSell {
    public static void main(String[] args) {
        int[] arr = { 7, 1, 5, 3, 6, 4 };
        System.out.println(maxProfit(arr));
    }

    // Only allowed to sell the stock one time
    public static int maxProfit(int[] arr) {
        // Max profit
        int max = 0;
        // Minimum value seen till now
        int min = Integer.MAX_VALUE;

        // traverse the array
        for (int i = 0; i < arr.length; i++) {
            // Update the min element
            if (arr[i] < min) {
                min = arr[i];
            }
            // Update the final result
            max = Math.max(max, arr[i] - min);
        }

        return max;
    }
}
