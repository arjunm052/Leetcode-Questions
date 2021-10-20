import java.util.*;

public class addNumbers {
    public static void main(String[] args) {

    }

    // Add two numbers represented as a linked list in reverse order
    public static ListNode addTwoNumbers(ListNode node1, ListNode node2) {
        // Create a dummy node that will store reference to our resultant head
        ListNode dummy = new ListNode(0);
        // Create a temp l3 pointer to traverse the resultant list
        ListNode l3 = dummy;

        // Variable to keep track of carry generated
        int carry = 0;

        // Traverse both the lists
        while (l1 != null || l2 != null) {
            // Extract the values of the current node
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            // Calculate the sum
            int currSum = val1 + val2 + carry;
            // Calculate carry generated
            carry = currSum / 10;
            // Calculate the last digit generated
            int lastDigit = currSum % 10;

            // Make a new node of Last Digit and add it to the resultant list
            ListNode newNode = new ListNode(lastDigit);
            // Add the node to the resultant list
            l3.next = newNode;

            // Increment the orignal list pointers
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;

            // Increment the resultant list pointer
            l3 = l3.next;

        }

        // If any carry left at the end then also add it to the resultant list
        if (carry > 0) {
            ListNode newNode = new ListNode(carry);
            l3.next = newNode;
            l3 = l3.next;
        }

        // Return the head to the resultant list
        return dummy.next;
    }
}
