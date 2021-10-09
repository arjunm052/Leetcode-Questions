import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class mergeK {
    public static void main(String[] args) {

    }

    // Divide and conquer approach used
    // TIME COMPLEXITY O(NlogK)

    // This is the function that we call
    public Node mergeKLists(Node[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        return mergeK(lists, 0, lists.length - 1);
    }

    // This is the main function same as merge sort
    public Node mergeK(Node[] lists, int start, int end) {
        if (start == end)
            return lists[start];
        int mid = start + (end - start) / 2;
        Node left = mergeK(lists, start, mid);
        Node right = mergeK(lists, mid + 1, end);
        return mergeTwoLists(left, right);
    }

    // Merge two lists l1 and l2
    public Node mergeTwoLists(Node l1, Node l2) {
        Node temp = new Node(0);
        Node curr = temp;

        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }

            curr = curr.next;
        }

        if (l1 != null) {
            curr.next = l1;
        }

        else if (l2 != null) {
            curr.next = l2;
        }

        return temp.next;
    }
}
