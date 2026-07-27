/**
 * https://neetcode.io/problems/reorder-linked-list/question?list=neetcode150
 * 
 * You are given the head of a singly linked-list.
 * The positions of a linked list of length = 7 for example, can intially be represented as:
 * [0, 1, 2, 3, 4, 5, 6]
 * Reorder the nodes of the linked list to be in the following order:
 * [0, 6, 1, 5, 2, 4, 3]
 * Notice that in the general case for a list of length = n the nodes are reordered to be in the following order:
 * [0, n-1, 1, n-2, 2, n-3, ...]
 * You may not modify the values in the list's nodes, but instead you must reorder the nodes themselves.
 * 
 * Constraints:
 * 1 <= Length of the list <= 1000.
 * 1 <= Node.val <= 1000
 * 
*/
public class ReorderLinkedList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode sp = head;
        ListNode fp = head;

        while (fp != null && fp.next != null) {
            sp = sp.next;
            fp = fp.next.next;
        }

        fp = sp.next;
        sp.next = null;
        sp = head;

        ListNode previous = null;
        while (fp != null) {
            ListNode next = fp.next;
            fp.next = previous;
            previous = fp;
            fp = next;
        }

        fp = previous;        
        while (fp != null) {
            ListNode fn = sp.next;
            ListNode sn = fp.next;
            sp.next = fp;
            fp.next = fn;
            sp = fn;
            fp = sn;
        }
    }
}