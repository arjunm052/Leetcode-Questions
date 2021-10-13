import java.util.*;

public class sumIntegers {
    public static void main(String[] args) {

    }

    public int getSum(int a, int b) {
        // Use XOR to generate sum
        int runSum = 1;
        // Use AND to generate carry
        int carry = 1;

        // While carry doesn't become zero do
        while (carry != 0) {
            // generate carry
            carry = a & b;
            // generate sum
            runSum = a ^ b;
            // make a as the running sum
            a = runSum;
            // make b as the carry left shifted by 1
            b = carry << 1;
        }

        // final result is in runSum
        return runSum;
    }
}
