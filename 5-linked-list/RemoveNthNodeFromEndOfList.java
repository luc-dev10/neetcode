/**
 * 
 * https://neetcode.io/problems/remove-node-from-end-of-linked-list/question?list=neetcode150
 * 
 * Given the head of a linked list and an integer n, remove the nth node from the end of the list and return its head.
 * 
 * Constraints:
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 */
public class RemoveNthNodeFromEndOfList() {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode sp = dummy;
        ListNode fp = dummy;

        for (int i = 0; i < n; i++) fp = fp.next;

        while (fp.next != null) {
            sp = sp.next;
            fp = fp.next;
        }

        sp.next = sp.next.next;
        return dummy.next;
    }
}