import java.util.*;

class Node {
    int val;
    Node left;
    Node right;
}

public class sameTree {
    public static void main(String[] args) {

    }

    public static boolean isSame(Node p, Node q) {
        // If both the trees are null then they are same
        if (p == null && q == null) {
            return true;
        }
        // If either one of the trees is null and other is not then they are not same
        else if (p == null || q == null) {
            return false;
        }
        // If the value of the roots are not equal then are are not same
        else if (p.val != q.val) {
            return false;
        }
        // Recursively check for left and right subtree
        else {
            return isSame(p.left, q.left) && isSame(p.right, q.right);
        }
    }
}
