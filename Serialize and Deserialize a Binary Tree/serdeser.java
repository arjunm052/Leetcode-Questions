import java.util.*;

public class serdeser {
    public static void main(String[] args) {

    }

    // Serialize a Binary Tree into a compact string and again deserialize that
    // string to form a Binary Tree.

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        // Base case when we encounter a null node
        if (root == null) {
            return "X";
        }
        // Get the left serialized tree
        String left = serialize(root.left);
        // Get the right serialized tree
        String right = serialize(root.right);

        // Make the resultant string and return it
        return root.val + "," + left + "," + right;
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        // Push all the nodes into a queue
        Queue<String> nodesLeft = new LinkedList<String>();
        nodesLeft.addAll(Arrays.asList(data.split(",")));
        // and return the deserialized binary tree
        return deserializeHelper(nodesLeft);
    }

    public static TreeNode deserializeHelper(Queue<String> nodesLeft) {
        // Remove a node from the queue
        String value = nodesLeft.poll();
        // if it is equal to null then just return null
        if (value.equals("X"))
            return null;
        // Else create a new node from the nodes value
        TreeNode newNode = new TreeNode(Integer.valueOf(value));
        // Create it's left and right subtree
        newNode.left = deserializeHelper(nodesLeft);
        newNode.right = deserializeHelper(nodesLeft);
        // return the new node
        return newNode;
    }
}
