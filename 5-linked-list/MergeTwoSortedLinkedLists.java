/**
 * 
 *  https://neetcode.io/problems/merge-two-sorted-linked-lists/question?list=neetcode150
 * 
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists into one sorted linked list and return the head of the new sorted linked list.
 * The new list should be made up of nodes from list1 and list2.
 * 
 * Constraints:
 * 0 <= The length of the each list <= 100.
 * -100 <= Node.val <= 100
 * 
 */

public class MergeTwoSortedLinkedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode lp = list1;
        ListNode rp = list2;
        ListNode current = dummy;

        while (lp != null && rp != null) {
            if (lp.val <= rp.val) {
                current.next = lp;
                lp = lp.next;
            } else {
                current.next = rp;
                rp = rp.next;
            }

            current = current.next;
        }

        current.next = (lp != null) ? lp : rp;
        return dummy.next;
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