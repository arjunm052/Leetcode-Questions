import java.util.*;

public class prod {
    public static void main(String[] args) {

    }

    public static int[] prodArray(int[] arr) {
        int[] res = new int[arr.length];
        res[0] = 1;
        // First find the left product of the array and store it in res array
        for (int i = 1; i < arr.length; i++) {
            res[i] = res[i - 1] * arr[i - 1];
        }

        // Then find the right product of the array and update the res array
        int rightProd = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            res[i] = res[i] * rightProd;
            rightProd *= arr[i];
        }
        // return final res
        return res;
    }
}
