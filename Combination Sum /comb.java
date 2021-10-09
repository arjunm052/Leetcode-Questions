import java.util.*;

public class comb {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 6, 7 };
        int target = 7;
        System.out.println(solve(arr, target));
    }

    public static List<List<Integer>> solve(int[] arr, int target) {
        // Resultant list
        List<List<Integer>> res = new ArrayList<>();
        findCombination(0, arr, target, res, new ArrayList<>());
        return res;
    }

    // Classic backtracking problem
    // We either pick the number or we dont
    // Multiple pickings allowed in this VERSION
    public static void findCombination(int index, int[] arr, int target, List<List<Integer>> res, List<Integer> ds) {
        // If we have exhausted the array and the target has also become then we have
        // got the combination. Just return from there
        if (index == arr.length) {
            if (target == 0) {
                res.add(new ArrayList<>(ds));
            }
            return;
        }

        // We can only pick the number if it is less than the target number
        if (arr[index] <= target) {
            // First pick the number
            ds.add(arr[index]);
            // Find next permutation after picking the current number
            findCombination(index, arr, target - arr[index], res, ds);
            // Remove the last number that we picked
            ds.remove(ds.size() - 1);
        }
        // Recursive call for when we don't pick the current number
        findCombination(index + 1, arr, target, res, ds);
    }

    // In this COMBINATION-II Problem we are only allowed to pick the number once
    public static void findUniqueCombinations(int index, int[] arr, int target, List<List<Integer>> res,
            List<Integer> ds) {
        // If target has become zero then we have found the number
        if (target == 0) {
            res.add(new ArrayList<>(ds));
            return;
        }

        // Iterate over all the indexes and once we pick an element we can't pick it
        // again as the starting index
        for (int i = index; i < arr.length; i++) {
            // If an element is picked it can't be picked again as a starting index for that
            // recursion branch
            if (i > index && arr[i] == arr[i - 1])
                continue;
            // Not possible to pick that element
            if (arr[index] > target)
                break;

            // Pick the element
            ds.add(arr[i]);
            // Make the next recursive call
            findUniqueCombinations(index + 1, arr, target - arr[i], res, ds);
            // Remove that element
            ds.remove(ds.size() - 1);
        }

    }
}
