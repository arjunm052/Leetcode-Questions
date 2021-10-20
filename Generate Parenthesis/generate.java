import java.util.*;

public class generate {
    public static void main(String[] args) {

    }

    public static List<String> generateParenthesis(int n) {
        // Create resultant list
        List<String> res = new ArrayList<>();
        // Call backtracking function
        backtrack(res, "", 0, 0, n);
        // return the res
        return res;
    }

    public static void backtrack(List<String> res, String currString, int open, int close, int max) {
        // base case - string length should be equal to max no. of parenthesis that we
        // can have
        if (currString.length() == max * 2) {
            // just add the current string to result and return
            res.add(currString);
            return;
        }

        // Opening braces should be less than max no. of opening parenthesis that we can
        // have then only call the recursive function
        if (open < max) {
            backtrack(res, currString + "(", open + 1, close, max);
        }
        // closing braces should be less then opening braces then only call this
        // recursive function
        if (close < open) {
            backtrack(res, currString + ")", open, close + 1, max);
        }

    }
}
