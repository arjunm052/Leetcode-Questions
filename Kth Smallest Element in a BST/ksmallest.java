import java.util.*;

public class ksmallest {
    public static void main(String[] args) {

    }

    public static int kthSmallest(TreeNode root, int k) {
        int[] res = new int[2];
        ksmall(root, res, k);
        return res[1];
    }

    // We traverse in an inorder way
    public static void ksmall(TreeNode root, int[] res, int k) {
        // base case
        if (root == null) {
            return;
        }

        // Recursively go to the left node
        ksmall(root.left, res, k);

        // We have reached the smallest element in BST. Now check if it is the required
        // element
        if (++res[0] == k) {
            res[1] = root.val;
        }

        // Recursively go to the right subtree
        ksmall(root.right, res, k);
    }

}
