/**
 * https://neetcode.io/problems/reverse-nodes-in-k-group/question?list=neetcode150
 * 
 * You are given the head of a singly linked list head and a positive integer k.
 * You must reverse the first k nodes in the linked list, and then reverse the next k nodes, and so on. If there are fewer than k nodes left, leave the nodes as they are.
 * Return the modified list after reversing the nodes in each group of k.
 * You are only allowed to modify the nodes' next pointers, not the values of the nodes.
 * 
 * Constraints: 
 * The length of the linked list is n
 * 1 <= k <= n <= 5000
 * 0 <= Node.val <= 100
 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        ListNode ll = dummy;
        ll.next = head;
        ListNode r = this.getRight(ll.next, k);

        while (r != null) {
            ListNode l = ll.next;
            ListNode rl = r.next;
            ListNode p = null;
            ListNode c = l;

            while (c != rl) {
                ListNode n = c.next;
                c.next = p;
                p = c;
                c = n;
            }

            ll.next = p;
            l.next = rl;
            ll = l;
            r = this.getRight(ll.next, k);
        }
        
        return dummy.next;
    }

    public ListNode getRight(ListNode n, int k) {
        ListNode c = n;
        int i = 1;
        while (c != null) {
            if (i == k) return c;
            i++;
            c = c.next;
        }
        return null;
    }
}
