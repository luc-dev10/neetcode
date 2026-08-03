/**
 * https://neetcode.io/problems/add-two-numbers/question?list=neetcode150
 * 
 * You are given two non-empty linked lists, l1 and l2, where each represents a non-negative integer.
 * The digits are stored in reverse order, e.g. the number 321 is represented as 1 -> 2 -> 3 -> in the linked list.
 * Each of the nodes contains a single digit. You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Return the sum of the two numbers as a linked list.
 * 
 * Constraints:
 * 1 <= l1.length, l2.length <= 100.
 * 0 <= Node.val <= 9
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode fp = l1;
        ListNode sp = l2;
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        int c = 0;

        while (fp != null || sp != null || c != 0) {
            int f = fp != null ? fp.val : 0;
            int s = sp != null ? sp.val : 0;
            int t = (c + f + s) % 10;
            c = (c + f + s) / 10;

            current.next = new ListNode(t);
            current = current.next;
            fp = fp != null ? fp.next : null;
            sp = sp != null ? sp.next : null;
        }

        return dummy.next;
    }
}
