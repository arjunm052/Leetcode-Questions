import java.util.*;

public class lcabt {
    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base Case
        if (root == null || root == p || root == q) {
            return root;
        }

        // Recurse for left and right subtree
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // if left is null then return right
        if (left == null) {
            return right;
        }
        // If right is null then return left
        else if (right == null) {
            return left;
        }
        // if neither of them are null then we have found our lca
        else {
            return root;
        }

    }

}
