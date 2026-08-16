/**
 * https://neetcode.io/problems/merge-k-sorted-linked-lists/question?list=neetcode150
 * 
 * You are given an array of k linked lists lists, where each list is sorted in ascending order.
 * 
 * Return the sorted linked list that is the result of merging all of the individual linked lists.
 * 
 * Constraints:
 * 0 <= lists.length <= 10000
 * 0 <= lists[i].length <= 500
 * -10000 <= lists[i][j] <= 10000
 * lists[i] is sorted in ascending order.
 * The sum of lists[i].length will not exceed 10000.
 */
public class MergeKSortedLinkedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        for (int i = 1; i <= lists.length; i *= 2) {
            for (int j = 0; j < lists.length; j = j + 2 * i) {
                int r = j + i;
                ListNode a = lists[j];
                ListNode b = r >= lists.length ? null : lists[r];
                lists[j] = merge(a, b);
            }
        }

        return lists[0];
    }

    private ListNode merge(ListNode a, ListNode b) {
        ListNode fp = a;
        ListNode sp = b;
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (fp != null && sp != null) {
            if (fp.val <= sp.val) {
                current.next = fp;
                fp = fp.next;
            } else {
                current.next = sp;
                sp = sp.next;
            }

            current = current.next;
        }

        current.next = fp != null ? fp : sp; 
        return dummy.next;
    }
}
