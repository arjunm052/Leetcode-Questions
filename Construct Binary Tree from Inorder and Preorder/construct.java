import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.val = data;
        this.left = this.right = null;
    }
}

public class construct {
    public static void main(String[] args) {

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Hash the indexes of inorder for faster access
        Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        TreeNode root = build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);

        return root;
    }

    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
            Map<Integer, Integer> inMap) {

        // If no preorder or inorder exists then just return null
        if (preStart > preEnd || inStart > inEnd)
            return null;

        // create the node from the preorder
        TreeNode root = new TreeNode(preorder[preStart]);

        // index of root in Inorder
        int inRoot = inMap.get(root.val);
        // calculating the numbers left
        int numsLeft = inRoot - inStart;

        // build left side of tree
        root.left = build(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inMap);
        // build right side of tree
        root.right = build(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);

        // return the root
        return root;
    }
}
