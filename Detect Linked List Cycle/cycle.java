import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class cycle {
    public static void main(String[] args) {

    }

    // We use slow and fast pointer technique
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        int flag = 0;

        // Traverse until one of the pointers become null
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // if fast and slow ever point to the same node then there exists a cycle
            if (slow == fast) {
                flag = 1;
                break;
            }
        }

        // if cycle detected then return true else return false
        if (flag == 1) {
            return true;
        } else {
            return false;
        }

    }
}
