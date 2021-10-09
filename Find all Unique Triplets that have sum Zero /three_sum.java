import java.util.*;

public class three_sum {
    public static void main(String[] args) {
        int[] arr = { -1, 0, 1, 2, -1, -4 };
        System.out.println(solve(arr));
    }

    public static List<List<Integer>> solve(int[] arr) {
        // Resultant List
        List<List<Integer>> res = new LinkedList<>();
        // First sort the array
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; i++) {
            // If the previous number is same as current number we skip the iteration
            if (i == 0 || (i > 0 && arr[i] != arr[i - 1])) {

                // Calculate the starting and ending index and then apply the two sum technique
                // on the rest of the array
                int low = i + 1;
                int high = arr.length - 1;
                int sum = 0 - arr[i];

                // Applying the two sum technique
                while (low < high) {
                    // If we found a triplet then add to the result
                    if (arr[low] + arr[high] == sum) {
                        res.add(Arrays.asList(arr[i], arr[low], arr[high]));
                        // If we have repeating elements then just skip over them for both left and
                        // right pointer
                        while (low < high && arr[low] == arr[low + 1])
                            low++;
                        while (low < high && arr[high] == arr[high - 1])
                            high--;
                        // Change pointers to find other triplets
                        low++;
                        high--;
                    }
                    // If the pair is greater than sum than just decrease the right pointer else
                    // increase the left pointer
                    else if (arr[low] + arr[high] > sum) {
                        high--;
                    } else {
                        low++;
                    }
                }

            }
        }

        // return the final result
        return res;
    }
}
