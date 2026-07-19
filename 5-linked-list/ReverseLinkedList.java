/**
 *
 * https://neetcode.io/problems/reverse-a-linked-list/question?list=neetcode150
 *
 * Given the beginning of a singly linked list head, reverse the list, and return the new beginning of the list.
 * 
 * 
 * Constraints:
 * 0 <= The length of the list <= 1000.
 * -1000 <= Node.val <= 1000
 **/

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
