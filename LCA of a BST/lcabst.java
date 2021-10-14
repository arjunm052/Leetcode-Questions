import java.util.*;

public class lcabst {
    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // If both lie in the left subtree then recur to the left sub tree
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        // // If both lie in the right subtree then recur to the right sub tree
        else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        // They both lie in the different sub tree so current node must be the lca for
        // the two nodes
        else {
            return root;
        }
    }
}
