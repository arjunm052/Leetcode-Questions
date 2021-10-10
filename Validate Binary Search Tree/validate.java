import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
}

public class validate {
    public static void main(String[] args) {

    }

    public static boolean isValid(Node root) {
        // Every value in the subtree should lie between the constraints passed to the
        // recursive call
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean checkBST(Node root, int min, int max) {
        // Base case
        if (root == null) {
            return true;
        }

        // If the value is not between constraints then just return false
        if (root.data < min || root.data > max) {
            return false;
        }

        // Value in the left subtree should be less than the root value and right
        // subtree should be greater than the root value for each subtree
        return (checkBST(root.left, min, root.data - 1) && checkBST(root.right, root.data + 1, max));
    }

}
