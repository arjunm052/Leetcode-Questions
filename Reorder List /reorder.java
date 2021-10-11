public class reorder {
    public static void main(String[] args) {

    }

    // ORIGNAL LIST
    // L1->L2->L3->L4.....->Ln-1->Ln

    // REORDERED LIST
    // L1->Ln->L2->Ln-1....@interface

    public static void reorderList(ListNode head) {
        // Base case
        if (head == null || head.next == null)
            return;

        // Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Set tail of first linked list to null
        prev.next = null;

        // Now we have two linked lists
        ListNode l1 = head;
        ListNode l2 = reverse(slow);

        // Finally Merge the two linked lists in alternating order
        merge(l1, l2);

    }

    // Function to reverse the linked list
    public static ListNode reverse(ListNode l2) {
        if (l2 == null)
            return null;
        ListNode prev = null;
        ListNode curr = l2;
        ListNode next = l2.next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    // Function to merge the linked list
    public static void merge(ListNode l1, ListNode l2) {
        while (l2 != null) {
            ListNode next = l1.next;
            l1.next = l2;
            l1 = l2;
            l2 = next;
        }
    }

}
