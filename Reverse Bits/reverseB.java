public class reverseB {
    public static void main(String[] args) {

    }

    public static int reverseBit(int n) {
        // final result
        int res = 0;

        // we do 32 iteration for 32 bits
        for (int i = 0; i < 32.; i++) {
            // calculate the last significant bit
            int lsb = n & 1;
            // get the reverse of it
            int reverseLsb = lsb << (31 - i);
            // do an or operation with the final ers
            res = res | reverseLsb;
            // right shift n one time
            n = n >> 1;
        }
        // return final res
        return res;

    }
}
