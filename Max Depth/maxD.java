import java.util.*;

public class maxD {
    public static void main(String[] args) {

    }

    public int maxDepth(Node root) {
        // If root is null then the max depth would be 0
        if (root == null) {
            return 0;
        }

        // Calculate depth of left subtree and right sub tree
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);

        // return the max of left , right + 1;
        return Math.max(l, r) + 1;

    }
}
