import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class mergeTwo {
    public static void main(String[] args) {

    }

    public static Node mergeTwoLists(Node l1, Node l2) {
        // Create a dummy node whose next will be the head of merged list
        Node temp = new Node(0);
        // Curr will always be at the tail of merged list
        Node curr = temp;

        // Traverse both the list and compare the values
        while (l1 != null && l2 != null) {
            // If node1 data is smaller then make the curr node point to it and increase the
            // current node and l1 node else do the same with node2
            if (l1.data < l2.data) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }

            curr = curr.next;
        }

        // If either of the list is empty then add them completely to the merged list as
        // it is
        if (l1 != null) {
            curr.next = l1;
        }

        else if (l2 != null) {
            curr.next = l2;
        }

        // return temp.next which would be the head of new list
        return temp.next;
    }
}
