import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class nthList {
    public static void main(String[] args) {

    }

    // One traversal solution
    public static Node solve(Node head, int n) {
        // Create a dummy node and point its next to the head
        Node start = new Node(0);
        start.next = head;

        // Create two pointers start and fast
        Node fast = start;
        Node slow = start;

        // Increment fast n times
        for (int i = 1; i <= n; i++) {
            fast = fast.next;
        }

        // Move both slow and fast until fast.next becomes null
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // just change the next of slow and return the start.next
        slow.next = slow.next.next;
        return start.next;
    }
}
