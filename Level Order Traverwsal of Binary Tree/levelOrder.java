import java.util.*;

import java.util.*;

class Node {
    int val;
    Node left;
    Node right;
}

public class levelOrder {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> levelOrderTraversal(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        // Base case
        if (root == null) {
            return res;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (q.isEmpty() == false) {
            // number of nodes in the level is size of the queue
            int size = q.size();
            // will contain nodes at a particular level
            List<Integer> list = new LinkedList<>();

            // Pop all the nodes in a level and add their child to the queue
            for (int i = 0; i < size; i++) {
                Node curr = q.remove();
                list.add(curr.val);
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            // add current level to the final result
            res.add(list);
        }

        // reutnr result
        return res;
    }
}
