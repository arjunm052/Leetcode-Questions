public class maxProd {
    public static void main(String[] args) {
        int[] arr = { 2, 3, -2, 4 };
        System.out.println(getMaxProd(arr));
    }

    // First, if there's no zero in the array, then the subarray with maximum
    // product must start with the first element or end with the last element. And
    // therefore, the maximum product must be some prefix product or suffix product.
    // So in this solution, we compute the prefix product A and suffix product B,
    // and simply return the maximum of A and B.

    // What if there are zeroes in the array? Well, we can split the array into
    // several smaller ones. That's to say, when the prefix product is 0, we start
    // over and compute prefix profuct from the current element instead

    public static int getMaxProd(int[] arr) {
        // Calculate prefix sum and suffix sum and take max of them
        int n = arr.length, res = arr[0], l = 0, r = 0;
        for (int i = 0; i < n; i++) {
            // Start taking product from left. If we encounter a zero then start a new
            // subarray
            l = ((l == 0) ? 1 : l) * arr[i];
            // Start taking product from the right. If we encounter a zero then start a new
            // subarray
            r = ((r == 0) ? 1 : r) * arr[n - 1 - i];

            // Take max of these
            res = Math.max(res, Math.max(l, r));
        }

        return res;
    }
}
