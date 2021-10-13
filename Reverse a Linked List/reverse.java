public class reverse {
    public static void main(String[] args) {

    }

    public static TreeNode reverseList(ListNode root) {
        // Store curr node
        ListNode curr = root;
        // Points to the next node
        ListNode next = null;
        // Points to the prev node
        ListNode prev = null;

        while (curr != null) {
            // store the next node
            next = curr.next;
            // change next of current to prev
            curr.next = prev;
            // set curr to previous
            prev = curr;
            // change curr
            curr = next;

        }

        // return prev as head of new linked list
        return prev;
    }
}
