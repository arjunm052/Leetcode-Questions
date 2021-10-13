public class numbBits {
    public static void main(String[] args) {

    }

    public int hammingWeight(int n) {
        // initialize result
        int result = 0;
        // traverse all the 32 bits of the number
        for (int i = 0; i < 32; i++) {
            // check if the last bit is set
            int isSet = n & 1;
            // if it is set then increment the result
            if (isSet == 1) {
                result++;
            }
            // right shift the number by 1
            n = n >> 1;
        }

        // return the final result
        return result;

    }
}
