public class countBits {
    public static void main(String[] args) {

    }

    // Return an array where arr[i] denotes set bits in i
    public static int[] countbits(int n) {
        // res[i] denotes set bits in i
        int[] res = new int[n + 1];
        // set bits in 0 is 0
        res[0] = 0;

        // we fill up the table in bottom up manner
        for (int i = 1; i <= n; i++) {
            // if the number is odd then the no. of set bits in it will be 1 + no. of set
            // bits in i/2;
            if (i % 2 != 0) {
                res[i] = 1 + res[i / 2];
            }
            // if the no. is even then the number of set bits will be equal to set in in i/2
            else {
                res[i] = res[i / 2];
            }
        }

        // return the final array
        return res;
    }
}
