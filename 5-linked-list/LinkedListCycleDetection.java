/**
 * https://neetcode.io/problems/linked-list-cycle-detection/question?list=neetcode150
 * 
 * Given the beginning of a linked list head, return true if there is a cycle in the linked list. Otherwise, return false.
 * There is a cycle in a linked list if at least one node in the list can be visited again by following the next pointer.
 * Internally, index determines the index of the beginning of the cycle, if it exists. The tail node of the list will set it's next pointer to the index-th node. If index = -1, then the tail node points to null and no cycle exists.
 * Note: index is not given to you as a parameter.
 * 
 * Constraints:
 * 0 <= Length of the list <= 1000
 * -1000 <= Node.val <= 1000
 * index is -1 or a valid index in the linked list.
 */
public class LinkedListCycleDetection {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode sp = head;
        ListNode fp = head;

        while (sp != null && sp.next != null) {
            fp = fp.next;
            sp = sp.next.next;
            if (sp == fp) return true;
        }

        return false;
    }
}