public class invert {
    public static void main(String[] args) {

    }

    public static TreeNode invertTree(TreeNode root) {
        // Call the helper function and return the root
        invertHelp(root);
        return root;
    }

    public static void invertHelp(TreeNode root) {
        // Base case
        if (root == null) {
            return;
        }

        // Store the left and right nodes
        TreeNode left = root.left;
        TreeNode right = root.right;

        // Interchange them
        root.left = right;
        root.right = left;

        // and recrusively call for the left and right subtree
        invertHelp(root.left);
        invertHelp(root.right);
    }
}
