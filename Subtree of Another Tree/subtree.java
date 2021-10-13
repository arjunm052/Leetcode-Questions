public class subtree {
    public static void main(String[] args) {

    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // if root == null then subRoot can never be a sub tree
        if (root == null) {
            return false;
        }
        // Magic Function! returns true if both trees are the same
        else if (sameTree(root, subRoot)) {
            return true;
        }
        // Otherwise we check for both left and right subtree
        else {
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }
    }

    public static boolean sameTree(TreeNode root, TreeNode subRoot) {
        // base case
        if (root == null || subRoot == null) {
            return (root == null && subRoot == null);
        }
        // If value of both nodes is same then we make sure that rest of the structure
        // is same as well
        else if (root.val == subRoot.val) {
            return sameTree(root.left, subRoot.left) && sameTree(root.right, subRoot.right);
        }
        // otherwise just return false
        else {
            return false;
        }
    }
}
