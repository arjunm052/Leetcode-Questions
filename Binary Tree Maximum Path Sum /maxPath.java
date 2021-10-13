public class maxPath {

    static int result;

    public static void main(String[] args) {

    }

    public static int maxPathSum(Node root) {
        // initialize global result to min value
        result = Integer.MIN_VALUE;
        // call the util function
        maxPathUtil(root);
        // return final result
        return result;

    }

    public static int maxPathUtil(Node root) {
        // base case
        if (root == null) {
            return 0;
        }

        // calculate sum for left and right subtrees
        int left = maxPathUtil(root.left);
        int right = maxPathUtil(root.right);

        // Case 1 - Maximum Path Sum passes through the current node
        int passThrough = Math.max(Math.max(left, right) + root.val, root.val);
        // Case 2 - Current node is the root of Maximum Path sum
        int isRoot = Math.max(passThrough, left + right + root.val);
        // Compare both the cases and store the max value infinal result
        result = Math.max(result, isRoot);

        // return the passThrough sum back to the upper nodes
        return passThrough;
    }

}
