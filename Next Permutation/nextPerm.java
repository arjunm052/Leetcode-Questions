import java.util.*;

public class nextPerm {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 2 };
        System.out.println(Arrays.toString(getNext(arr)));
    }

    public static int[] getNext(int[] arr) {
        // Base cases
        if (arr.length == 1) {
            return arr;
        }

        if (arr.length == 2) {
            reverse(arr, 0, 1);
            return arr;
        }

        // First we have to find the prefix that is just greater than the current one.
        // Prefix is just to the left of where the breakdown happens
        int i = 0;
        for (i = arr.length - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                break;
            }
        }

        // If no No next permutation exists then just return the smallest number that
        // can be formed
        if (i < 0) {
            reverse(arr, 0, arr.length - 1);
            return arr;
        }

        /// Else find the number just greater than the prefix point and swap them
        int j = 0;
        for (j = arr.length - 1; j >= 0; j--) {
            if (arr[j] > arr[i]) {
                break;
            }
        }

        swap(arr, i, j);
        // Then just reverse the whole array from the index+1 of prefix point
        reverse(arr, i + 1, arr.length - 1);
        return arr;

    }

    public static void reverse(int[] arr, int i, int j) {
        while (i < j) {
            swap(arr, i++, j--);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
